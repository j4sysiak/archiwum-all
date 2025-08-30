package com.example.demo.gui;

import com.example.demo.repository.RectangleRepo;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class RectangleSizeGui extends VerticalLayout {

    //wstrzykujemy repo - żeby coś z bazą zrobić
    private RectangleRepo rectangleRepo;

    private TextArea textAreaRectangles;
    private TextField textFieldSize;
    private Button buttonBigger;
    private Button buttonSmaller;

    @Autowired
    public RectangleSizeGui(RectangleRepo rectangleRepo) {
        this.rectangleRepo = rectangleRepo;
        this.textFieldSize = new TextField("Podaj rozmiar: ");
        this.textAreaRectangles = new TextArea("Wynik: ");
        this.buttonBigger = new Button("Pokaż większe");
        this.buttonSmaller = new Button("Pokaż mniejsze");

        buttonBigger.addClickListener(buttonClickEvent -> textAreaRectangles.setValue(rectangleRepo
                .getListOfBigRectangles(Integer.parseInt(textFieldSize.getValue())).toString()));

        buttonSmaller.addClickListener(buttonClickEvent -> textAreaRectangles.setValue(rectangleRepo
                .getListOfSmallRectangles(Integer.parseInt(textFieldSize.getValue())).toString()));

        add(textAreaRectangles);
        add(textFieldSize);
        add(buttonBigger);
        add(buttonSmaller);
    }

}
