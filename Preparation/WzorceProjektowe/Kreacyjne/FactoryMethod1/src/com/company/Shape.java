package com.company;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Shape {

     int x;
     int y;

    public abstract void render();
}
