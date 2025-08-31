package com.company;

import com.company.shapes.Circle;
import com.company.shapes.Rectangle;
import com.company.shapes.Triangle;

public class ShapeFactory {



    public IShape /*lub Shape*/ createShape(ShapeType type) throws Exception {

        switch (type) {
            case Circle: return new Circle(1, 2);
            case Rectangle: return new Rectangle(3, 4);
            case Triangle: return new Triangle(5, 6);
            default: throw new Exception("Shape type not handled");
        }
    }
}
