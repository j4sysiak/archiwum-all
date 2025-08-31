package com.company.shapes;

import com.company.IShape;
public class Circle /*lub extends Shape*/ implements IShape {

    int a, b;

    public Circle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void render() {
        System.out.println("Render Circle ... " + this.a  +":"+ this.b);
    }
}
