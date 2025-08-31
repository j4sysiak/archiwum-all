package com.company.przypadekSwitchInStream.modulelevel2;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Point {
    public int x;
    public int y;

    public static Point create(int x, int y) {
        return Point.builder()
                .x(x)
                .y(y)
                .build();
    }
}
