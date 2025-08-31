package com.company;

import lombok.Getter;

@Getter
public class EmptyInvoiceBuilder implements IInvoiceBuilder {

    private Invoice invoice;

    EmptyInvoiceBuilder() {
        // najpierw tworzymy instancję klasy Invoice - przez wstrzyknięcie w konstruktorze.
        this.invoice = new Invoice();
   }

    // to jest najwazniejsza metoda, która zwróci naszą fakturę
    public Invoice build() {
        return this.getInvoice();
    }

    public void setVendor(String vendor) {
        this.invoice.vendor = vendor;
    }

    public void setNote(String note) {
        this.invoice.note = note;
    }


}
