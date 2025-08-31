package com.company.entity;

import com.company.classlevel.LineItem;
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
    public float totalNetto;
    public float totalBrutto;

    public static Invoice create(Collection<LineItem> lineItems, String vendor, String vendee) {
        return Invoice.builder()
                .lineItems(lineItems)
                .vendor(vendor)
                .vendee(vendee)
                .total(calculateTotal(lineItems))
                .totalNetto(calculateTotalNetto(lineItems))
                .totalBrutto(calculateTotalBrutto(lineItems))
                .build();
    }

    public static float calculateTotal(Collection<LineItem> lineItems) {
        return lineItems.stream()
                .map(lineItem -> lineItem.price)
                .reduce(0f, (x, y) -> x + y)
                ;
    }

    public static float calculateTotalNetto(Collection<LineItem> lineItems) {
        return lineItems.stream()
                .map(lineItem -> lineItem.price)
                .reduce(0f, (x, y) -> x + y-100)
                ;
    }

    public static float calculateTotalBrutto(Collection<LineItem> lineItems) {
        return lineItems.stream()
                .map(lineItem -> lineItem.price)
                .reduce(0f, (x, y) -> x + y+100)
                ;
    }
}
