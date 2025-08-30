package com.example.demo.gui;

import com.example.demo.model.Rectangle;
import com.example.demo.repository.RectangleRepo;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// odpalamy tą stronę:  http://localhost:8080/rectanglegui

@Route
public class RectangleGui extends VerticalLayout {

    // Żeby zapisać Rectangle w bazie to musimy wstrzyknąć beana RectangleRepo
    private RectangleRepo rectangleRepo;


    private TextField textFieldHeight;
    private TextField textFieldWeight;
    private Button button;

    @Autowired  // służy do wstrzykiwania rectangleRepo
    public RectangleGui(RectangleRepo rectangleRepo) {
        this.rectangleRepo = rectangleRepo;
        this.textFieldHeight = new TextField("Podaj wysokość: ");
        this.textFieldWeight = new TextField("Podaj szerokość: ");
        this.button = new Button("Dodaj");

        button.addClickListener(buttonClickEvent -> addRectangle());

        add(textFieldHeight);
        add(textFieldWeight);
        add(button);
    }

    public void addRectangle() {
        // w konstruktorze wstrzyknęliśmy rectangleRepo, żeby teraz wykorzystać ten bean do zapisu w bazie obiekt Rectangle
        rectangleRepo.save(Rectangle.builder()
                .height(Integer.parseInt(textFieldHeight.getValue()))
                .weight(Integer.parseInt(textFieldWeight.getValue()))
                .build());
    }
}
