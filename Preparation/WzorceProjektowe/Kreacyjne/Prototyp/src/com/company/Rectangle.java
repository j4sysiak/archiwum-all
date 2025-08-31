package com.company;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Rectangle extends Shape {


    @Builder
    public Rectangle(int x, int y, Border border) {
        super(x, y, border);
    }

    public static Rectangle create(int x, int y, Border border) {
        return Rectangle.builder()
                .x(x)
                .y(y)
                .border(border)
                .build();
    }

    @Override
    public void render() {
        System.out.println("Render Rectangle ...");
    }

    @Override
    // musi być zwrotka na biekcie Shape, bo interfajce tak jest zdefiniowany (musi być generyczny)
    public Shape cloning() {
        // jesteśmy w Rectangle, więc chcemy żeby zwrotka była Rectangle, więc rzutujemy na Rectangle
        return (Rectangle) this.clone();  //deepCopy
    }

    @Override
    //deepCopy
    public Object clone() {
        Rectangle rectangle = null;
        try {
            //Note that the super.clone() call returns a shallow copy of an object,
            // but we set deep copies of mutable fields manually, so the result is correct:
            rectangle = (Rectangle) super.clone();
        } catch (CloneNotSupportedException e) {
            //only shallow clone
            rectangle = new Rectangle(
                    this.x, this.y, this.getBorder());
        }
        //deep clone
        rectangle.border = (Border) this.border.clone();
        return rectangle;
    }
}
