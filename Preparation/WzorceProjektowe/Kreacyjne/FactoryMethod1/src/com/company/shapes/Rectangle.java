package com.company.shapes;

import com.company.IShape;

public class Rectangle  /*lub extends Shape*/ implements IShape {

    int a, b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void render() {
        System.out.println("Render Rectangle ... " + this.a  +":"+ this.b);
    }
}
