package com.ecommerce.springecommerce.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class UploadFileService {
    private String folder="images//";

    public String saveImage(MultipartFile file) throws IOException {
        if (!file.isEmpty()){
            byte [] bites= file.getBytes();
            Path path = Paths.get(folder+file.getOriginalFilename());
            Files.write(path,bites);
            return file.getOriginalFilename();
        }
        return "default.jpg";
    }

    public void deleteImage(String filename) {
        String route= "images//";
        File file = new File(route+filename);
        file.delete();
    }

}
