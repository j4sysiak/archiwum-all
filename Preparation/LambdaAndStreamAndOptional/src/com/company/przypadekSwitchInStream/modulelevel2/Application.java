package com.company.przypadekSwitchInStream.modulelevel2;

import java.util.Collection;
import java.util.stream.Collectors;

public class Application {

    public void render(Collection<Shape> shapes) {
//        for (Shape shape : shapes) {
//            ShapeType type = shape.shapeType;
//            switch (type) {
//                case Circle:
//                    renderCircle((Circle)shape);
//                    break;
//                case Rectangle:
//                    renderRectangle((Rectangle)shape);
//                    break;
//                default: return;
//            }
//        }

     shapes.stream()
                .map(f -> {
                    switch (f.getShapeType()) {
                        case Circle: renderCircle((Circle)f);break;
                        case Rectangle: renderRectangle((Rectangle)f);break;
                    }
                    return null;
                })
             .collect(Collectors.toList());
    }

    private void renderRectangle(Rectangle rectangle) {
        System.out.println("Render Rectangle ...");
    }

    private void renderCircle(Circle circle) {
        System.out.println("Render Circle ...");
    }
}
