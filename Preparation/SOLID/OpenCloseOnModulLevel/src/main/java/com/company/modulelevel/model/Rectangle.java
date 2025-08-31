package com.company.modulelevel.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Rectangle extends Shape {
    public int widht;
    public int height;
    public Point topLeft;

    @Builder
    public Rectangle(ShapeType type, int widht, int height, Point topLeft) {
       // super(type);
        this.widht = widht;
        this.height = height;
        this.topLeft = topLeft;
    }

    public static Rectangle create(ShapeType type, int w, int h, Point point) {
        return Rectangle.builder()
                .type(type)
                .widht(w)
                .height(h)
                .topLeft(point)
                .build();
    }

    @Override
    public void render() {
        System.out.println("Render Rectangle ...");
    }
}
