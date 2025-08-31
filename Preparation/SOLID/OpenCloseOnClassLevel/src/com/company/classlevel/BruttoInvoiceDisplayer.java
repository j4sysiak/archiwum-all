package com.company.classlevel;

import com.company.entity.Invoice;

public class BruttoInvoiceDisplayer implements IInvoiceDisplayer {

    @Override
    public void display(Invoice invoice) {
        System.out.println("BruttoInvoiceDisplayer ...." + invoice.totalBrutto);
    }
}
