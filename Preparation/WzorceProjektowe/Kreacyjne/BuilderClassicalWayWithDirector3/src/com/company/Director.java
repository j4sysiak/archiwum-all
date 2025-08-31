package com.company;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Director {

    private IInvoiceBuilder iInvoiceBuilder;

    Director(IInvoiceBuilder iInvoiceBuilder) {
        this.iInvoiceBuilder = iInvoiceBuilder;
    }
}
