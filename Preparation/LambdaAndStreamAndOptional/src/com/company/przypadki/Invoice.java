package com.company.przypadki;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Builder
@Getter
@Setter
public class Invoice {

    public Collection<LineItem> lineItems;
    public String vendor;
    public String vendee;
    public float total;

    public static Invoice create(Collection<LineItem> lineItems, String vendor, String vendee) {
        return Invoice.builder()
                .lineItems(lineItems)
                .vendor(vendor)
                .vendee(vendee)
                .total(calculateTotal(lineItems))
                .build();
    }

    public static float calculateTotal(Collection<LineItem> lineItems) {
        return lineItems.stream()
                .map(lineItem -> lineItem.price)
                .reduce(0f, (x, y) -> x + y)
                ;
    }
}