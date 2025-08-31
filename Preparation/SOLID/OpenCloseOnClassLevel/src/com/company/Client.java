package com.company;

import com.company.classlevel.*;
import com.company.entity.Invoice;

import java.util.Arrays;
import java.util.Collection;

public class Client {
    private static Collection<LineItem> lineItems;
    static {
        LineItem lineItem1 = LineItem.builder().name("aaa").price(11.99f).count(1f).taxRate(22).build();
        LineItem lineItem2 = LineItem.builder().name("bbb").price(12.99f).count(2f).taxRate(21).build();
        LineItem lineItem3 = LineItem.builder().name("ccc").price(13.99f).count(3f).taxRate(19).build();
        lineItems = Arrays.asList(lineItem1, lineItem2, lineItem3);
    }
    public static void main(String[] args) {

        Invoice invoice = Invoice.create(lineItems, "www", "sss");

        // wyswietlanie ceny Brutto
        IInvoiceDisplayer bruttoDisplay = new BruttoInvoiceDisplayer();
        InvoiceLogger.create(invoice, bruttoDisplay).display();

        // wyswietlanie ceny Netto
        IInvoiceDisplayer nettoDisplay = new NettoInvoiceDisplayer();
        InvoiceLogger.create(invoice, nettoDisplay).display();


        // zapis dokumentu w formacie PDF
        IInvoiceSaver pdfFormatSaver= new PdfInvoiceSaver();
        InvoicePersistence.create(invoice, pdfFormatSaver).save();

        // zapis dokumentu w formacie Word
        IInvoiceSaver wordFormatSaver= new WordInvoiceSaver();
        InvoicePersistence.create(invoice, wordFormatSaver).save();
    }
}
