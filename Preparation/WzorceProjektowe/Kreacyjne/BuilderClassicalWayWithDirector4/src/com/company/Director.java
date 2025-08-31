package com.company;

public class Director {

    private InvoiceBuilder invoiceBuilder;

    public Director(InvoiceBuilder invoiceBuilder) {
        this.invoiceBuilder = invoiceBuilder;
    }

    public Invoice createMonthlyInvoice() {
        return invoiceBuilder.setVendor("Brukbet")
                .setNote("dupa")
                .build();
    }

    public Invoice createVATInvoice() {
        return invoiceBuilder.setVendor("Prefabet")
                .setNote("dupadupadupadupa")
                .build();
    }
}
