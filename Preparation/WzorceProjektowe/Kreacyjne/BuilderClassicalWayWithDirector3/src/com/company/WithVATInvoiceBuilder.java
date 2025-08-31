package com.company;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WithVATInvoiceBuilder implements IInvoiceBuilder   {

    private Invoice invoice;

    WithVATInvoiceBuilder() {
        // najpierw tworzymy instancję klasy Invoice - przez wstrzyknięcie w konstruktorze.
        this.invoice = new Invoice();
    }

    public void setVendor(String vendor) {
        this.invoice.vendor = vendor;
    }

    public void setNote(String note) {
        this.invoice.note = note;
    }

    // to jest metoda, która zwróci naszą fakturę
    public Invoice build() {
        return this.getInvoice();
    }
}
