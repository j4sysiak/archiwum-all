package com.example.demo.gui;

import com.example.demo.repository.ImageRepo;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Route("galery")
public class GaleryGui extends VerticalLayout {

    //wstrzykujemy w konstruktorze instancję ImageUploader
    private ImageRepo imageRepo;

    @Autowired
    public GaleryGui(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;

        List<com.example.demo.model.Image> all = imageRepo.findAll();
        all.stream()
                .forEach(e -> {
                    com.vaadin.flow.component.html.Image image =
                            new com.vaadin.flow.component.html.Image(e.getImageAdress(), "brak");
                    add(image);
                });
    }
}
