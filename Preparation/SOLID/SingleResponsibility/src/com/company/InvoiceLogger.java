package com.company;

import com.company.entity.Invoice;
import lombok.Builder;

/* jedna odpowiedzialność klasy InvoiceLogger - display(...) */
@Builder
public class InvoiceLogger {

    private Invoice invoice;

    /* wstrzykujemy Invoice */
    public InvoiceLogger(Invoice invoice) {
        this.invoice = invoice;
    }
    public static InvoiceLogger create(Invoice invoice) {
        return InvoiceLogger.builder()
                .invoice(invoice)
                .build();
    }

    public void display() {
        System.out.println("Total: " + invoice.getTotal()  + " (lub):  " + invoice.total);
    }
}
