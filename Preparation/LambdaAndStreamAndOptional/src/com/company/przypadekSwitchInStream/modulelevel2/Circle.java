package com.company.przypadekSwitchInStream.modulelevel2;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Circle extends Shape {
    public int radius;
    public Point center;

    @Builder
    public Circle(ShapeType type, int radius, Point center) {
        super(type);
        this.radius = radius;
        this.center = center;
    }

    public static Circle create(ShapeType type, int r, Point point) {
        return Circle.builder()
                .type(type)
                .radius(r)
                .center(point)
                .build();
    }
}