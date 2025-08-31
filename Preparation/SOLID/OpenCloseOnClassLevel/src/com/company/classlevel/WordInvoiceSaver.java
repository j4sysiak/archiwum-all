package com.company.classlevel;

import com.company.entity.Invoice;

public class WordInvoiceSaver implements IInvoiceSaver {
    @Override
    public void save(Invoice invoice) {
        System.out.println("Saving invoice to WORD ...");
    }
}
