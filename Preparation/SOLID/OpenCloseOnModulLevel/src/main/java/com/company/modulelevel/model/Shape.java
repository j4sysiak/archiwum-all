package com.company.modulelevel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Shape {

   // public ShapeType shapeType;

    public abstract void render();

}
