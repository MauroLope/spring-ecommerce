package com.ecommerce.springecommerce.controller;

import com.ecommerce.springecommerce.model.Product;
import com.ecommerce.springecommerce.model.User;
import com.ecommerce.springecommerce.service.ProductService;
import com.ecommerce.springecommerce.service.UploadFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;
    private final UploadFileService upload;

    @Autowired
    public ProductController(ProductService productService, UploadFileService upload) {
        this.productService = productService;
        this.upload = upload;
    }

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products/show";
    }

    @GetMapping("/create")
    public String create(){
        return "products/create";
    }

    @PostMapping("/save")
    public String save(Product product,@RequestParam("img") MultipartFile file) throws IOException {
        LOGGER.info("este es el objeto producto {}",product);
        User user = new User(1L,"","","","","","","", new ArrayList<>(), new ArrayList<>());
        product.setUser(user);

        //imagen
        if (product.getId() == null) { //validacion cuando se crea un producto
            String nameImage = upload.saveImage(file);
            product.setImage(nameImage);
        } else {
            if (file.isEmpty()) { //editamos el producto pero no cambiamos la imagen
                Optional<Product> optionalProduct = productService.get(product.getId());
                if (optionalProduct.isPresent()) {
                    Product existingProduct = optionalProduct.get();
                    product.setImage(existingProduct.getImage());
                }
            } else {
                String nameImage = upload.saveImage(file);
                product.setImage(nameImage);
            }
        }

        productService.save(product);
        return "redirect:/products";
    }

    /*
    @PostMapping("/save")
public String save(Product product, @RequestParam("img") MultipartFile file) throws IOException {
    LOGGER.info("este es el objeto producto {}", product);
    User user = new User(1L, "", "", "", "", "", "", "", new ArrayList<>(), new ArrayList<>());
    product.setUser(user);

    // imagen
    if (product.getId() == null) {
        // Validación cuando se crea un producto
        String nameImage = upload.saveImage(file);
        product.setImage(nameImage);
    } else {
        processImageUpdate(product, file);
    }

    productService.save(product);
    return "redirect:/products";
}

private void processImageUpdate(Product product, MultipartFile file) throws IOException {
    if (file.isEmpty()) {
        productService.get(product.getId()).ifPresent(existingProduct -> {
            product.setImage(existingProduct.getImage());
        });
    } else {
        String nameImage = upload.saveImage(file);
        product.setImage(nameImage);
    }
}


    * */

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        Product product = new Product();
        Optional<Product> optionalProduct = productService.get(id);
        if (optionalProduct.isPresent()) {
            product = optionalProduct.get();
        }

        LOGGER.info("este es el  producto buscado {}",product);
        model.addAttribute("product", product);
        return "products/edit";
    }

    @PostMapping("/update")
    public String update(Product product){
        LOGGER.info("este es el  producto actualizado {}",product);
        productService.update(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        productService.delete(id);
        return "redirect:/products";
    }

}
