package com.company.classlevel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LineItem {
    public String name;
    public float price;
    public float count;
    public int taxRate;
}
