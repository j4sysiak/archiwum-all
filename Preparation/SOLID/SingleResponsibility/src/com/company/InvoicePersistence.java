package com.company;

import com.company.entity.Invoice;
import lombok.Builder;


/* jedna odpowiedzialność klasy InvoicePersistence - saveToPdf(...) */

@Builder
public class InvoicePersistence {

    private Invoice invoice;

    /* wstrzykujemy Invoice */
    public static InvoicePersistence create(Invoice invoice) {
        return InvoicePersistence.builder()
                .invoice(invoice)
                .build();
    }

    public void saveToPdf() {
        System.out.println("saveToPdf ... ");
    }
}
