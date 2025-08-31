package com.company.modulelevel;

import com.company.modulelevel.model.Shape;

import java.util.Collection;

public class Application {

    // Wszystkie klasy są otwarte na modyfikację i jednocześnie zamknięte.
    // Otwarte, bo dodając nowy kształt nic nie musimy robić w tych klasach: Shape, Rectangle, Circle (a jednocześnie są zamknięte) a funkcjonalność render() zadziała.
    // Jeżeli chcemy dodać nowy typ,
    // to po prostu rozszerzamy model np. o klasę Triangle i w tej klasie tworzymy swoisty render dla niej - tj. metodę render(), która opisuję tylko ten wybrany model.
    // Wywołanie render dla nowej klasy np. Triangle nie powoduje rozszerzenia klasy Application (jest zamknięta na rozszerzenia) i jedncześnie otwarta na nowy typ.
    // Tylko do listy shapes (w klasie Client) dopisujemy nowy obiekt Triangle.
    //     Triangle triangle = Triangle.create(ShapeType.Triangle, 11, Point.create(1, 222));

    public static void render(Collection<Shape> shapes) {

        // wykorzystujemy tu POLIMORFIZM: każdy kształt wywoła swoją metodę renderowania swojego kształtu (w swojej klasie)
        // nie musimy jużw pętli po typie kształtu (ShapeType) wywoływać metod do renderowania danego kształtu
    for (Shape shape : shapes) {
        shape.render();
    }

            /*
             for (Shape shape : shapes) {
            ShapeType type = shape.shapeType;
            switch (type) {
                case Circle:
                    renderCircle((Circle)shape);
                    break;
                case Rectangle:
                    renderRectangle((Rectangle)shape);
                    break;
                default: return;
            }
        }

     shapes.stream()
                .map(f -> {
                    switch (f.getShapeType()) {
                        case Circle: renderCircle((Circle)f);break;
                        case Rectangle: renderRectangle((Rectangle)f);break;
                    }
                    return null;
                })
             .collect(Collectors.toList());
*/


    }

//    private void renderRectangle(Rectangle rectangle) {
//        System.out.println("Render Rectangle ...");
//    }
//
//    private void renderCircle(Circle circle) {
//        System.out.println("Render Circle ...");
//    }
}
