package com.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public abstract class Shape {
   public int x;
   public int y;
   public Border border;

   public abstract void render();

   public abstract Shape cloning() throws CloneNotSupportedException;
}