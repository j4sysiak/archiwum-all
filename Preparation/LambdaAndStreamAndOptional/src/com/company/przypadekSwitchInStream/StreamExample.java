package com.company.przypadekSwitchInStream;

import com.company.przypadekSwitchInStream.modulelevel2.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class StreamExample {

    private Rectangle rectangle;
    private Circle circle;

    @BeforeEach
    public void setUp() {
        rectangle = Rectangle.create(ShapeType.Rectangle, 100, 200, Point.create(1, 1));
        circle = Circle.create(ShapeType.Circle, 22, Point.create(22, 22));
    }

    @Test
    public void test() {
        Application app = new Application();
        app.render(new ArrayList(Arrays.asList(rectangle, circle)));
    }
}
