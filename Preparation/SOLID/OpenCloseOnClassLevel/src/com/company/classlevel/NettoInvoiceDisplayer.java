package com.company.classlevel;

import com.company.entity.Invoice;

public class NettoInvoiceDisplayer implements IInvoiceDisplayer {
    @Override
    public void display(Invoice invoice) {
        System.out.println("NettoInvoiceDisplayer ..." + invoice.totalNetto);
    }
}
