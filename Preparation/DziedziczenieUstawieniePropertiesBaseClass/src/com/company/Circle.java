package com.company;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Circle extends Shape {
    public int radius;

    @Builder
    public Circle(int radius, int x, int y, Border border) {
        super(x, y, border);
        this.radius = radius;
    }

    public static Circle create(int r, int x, int y, Border border) {
        return Circle.builder()
                .radius(r)
                .x(x)
                .y(y)
                .border(border)
                .build();
    }

    @Override
    public void render() {
        System.out.println("Render Circle ...");
    }

    @Override
    public Shape cloning() throws CloneNotSupportedException {
        return (Circle) this.clone();  //shallowCopy
    }
}
