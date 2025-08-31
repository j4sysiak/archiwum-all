package com.company;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

@Setter
@Getter
public class ClientTest {

    @Test
    public void test() {
        InvoiceBuilder invoiceBuilder = new InvoiceBuilder();
        Director director = new Director(invoiceBuilder);

        Invoice vatInvoice = director.createVATInvoice();
        Invoice monthlyInvoice = director.createMonthlyInvoice();
        Invoice blankInvoice = director.createVATInvoice();
    }
}
