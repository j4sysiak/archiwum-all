package com.example.demo.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.model.Image;
import com.example.demo.repository.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploader {

    private Cloudinary cloudinary;
    private ImageRepo imageRepo;

    @Autowired
    public ImageUploader(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dmzun82tu",
                "api_key", "934522816349346",
                "api_secret", "1GwL921hBbmyJzR79Eoj9oQwBF8"));
    }

    // to trochę zjebane - bo jedna metoda powinna mieć jedną odpowiedzialność
    public String uploadFileAndSaveToDb(String path) {
        File file = new File(path);
        Map uploadResult = null;
        try {
            uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            imageRepo.save(Image.builder()
                              .imageAdress(uploadResult.get("url").toString())
                              .build());
        } catch (IOException e) {
            e.printStackTrace();
            //todo
        }
        return uploadResult.get("url").toString();
    }
}
