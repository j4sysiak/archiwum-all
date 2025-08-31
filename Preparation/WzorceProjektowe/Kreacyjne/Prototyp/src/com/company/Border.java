package com.company;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Border {

    public String color;
    public String size;

    @Override
    public Object clone() {
        Border border = null;
        try {
            // Note that the super.clone() call returns a shallow copy of an object,
            // but we set deep copies of mutable fields manually, so the result is correct:
            border = (Border) super.clone();
        } catch (CloneNotSupportedException e) {
            //depp clone
            border = new Border(
                    this.getColor(), this.getSize());
        }
        return border;
    }
}
