package com.company;

import java.util.List;
import static java.time.LocalDateTime.now;

public class Director {

    public Invoice createVATInvoice(InvoiceBuilder invoiceBuilder) {
        return invoiceBuilder.setDate(now())
                .setInvoiceNumber("V13132-2022")
                .setVendor("Suzuki")
                .setVendee("Blua")
                .setNote("dsdfdsf")
                .setLineItems(List.of("Line item1", "Line item32", "Line item3", "Line item4", "Line item5", "Line item6", "Line item7"))
                .build();
    }

    public Invoice createMonthlyInvoice(InvoiceBuilder invoiceBuilder) {
        return invoiceBuilder.setDate(now())
                .setInvoiceNumber("A13132-2022")
                .setVendor("Ford Motors Company Co. Limited")
                .setVendee("Jacek")
                .setNote("flsjdfjlsjdlfjlsjdfjsdjfsdlflsj")
                .setLineItems(List.of("Line item1", "Line item2"))
                .build();
    }

    public Invoice createBlankInvoice(InvoiceBuilder invoiceBuilder) {
        return invoiceBuilder.setDate(now())
                .setInvoiceNumber("000000-0000A")
                .setVendor("B L A N K")
                .setVendee("blank Blank")
                .setNote("BLANK")
                .setLineItems(List.of("BLANK"))
                .build();
    }
}
