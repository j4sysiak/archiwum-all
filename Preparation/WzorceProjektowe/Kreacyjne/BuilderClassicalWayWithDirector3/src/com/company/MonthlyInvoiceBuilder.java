package com.company;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MonthlyInvoiceBuilder implements IInvoiceBuilder   {

    private Invoice invoice;

    MonthlyInvoiceBuilder() {
        // najpierw tworzymy instancję klasy Invoice - przez wstrzyknięcie w konstruktorze.
        this.invoice = new Invoice();
    }

    // to jest metoda, która zwróci naszą fakturę
    public Invoice build() {
        return this.getInvoice();
    }

    public void setVendor(String vendor) {
        this.invoice.vendor = vendor;

        // Invoice inv = Invoice.builder().vendor("ss").note("ss").build();
    }

    public void setNote(String note) {
        this.invoice.note = note;
    }


}
