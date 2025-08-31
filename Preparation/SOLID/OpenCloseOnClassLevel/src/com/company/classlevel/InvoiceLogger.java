package com.company.classlevel;

import com.company.entity.Invoice;
import lombok.Builder;

@Builder
public class InvoiceLogger {

    private Invoice invoice;
    private IInvoiceDisplayer invoiceDisplayer;

    // clue OpenClose na poziomie klasy
    // kalsa InvoiceLogger jest otwarta na rozszerzenie, ponieważ wystarczy, że dostarczymy jej
    // inną implementację invoiceDisplayer
    // jednocześnie jest zamknięta na modyfikację, ponieważ z perspektywy tej klasy
    // nie jest wymagane, aby zmieniła ona swoją implementację
    // po to, żeby obsłużyć jakiś inny typ wyświetlania kwoty na fakturze np. bruttoAngielskie

    // WAŻNE: wstrzykujemy dwa obiekty: Obiekt klasy Invoice i Objekt Interfejsu IInvoiceDisplayer
    public static InvoiceLogger create(Invoice invoice, IInvoiceDisplayer iInvoiceDisplayer) {
        return InvoiceLogger.builder()
                .invoice(invoice)         //wstrzykujemy dwa obiekty: Obiekt klasy Invoice i Objekt Interfejsu IInvoiceDisplayer
                .invoiceDisplayer(iInvoiceDisplayer)
                .build();
    }

    // clue OpenClose
    //Metoda display ma ten sam kod niezależnie od tego jaki total chcemy wyświetlić (brutto czy netto)
    //ale implementacja leci do klasy, która ją wywołuje poprzez interface IInvoiceDisplayer invoiceDisplayer: od BruttoInvoiceDisplayer lub NettoInvoiceDisplayer
    public void display() {
        invoiceDisplayer.display(invoice);
    }

//    public void displayTotal() {
//        System.out.println("Total: " + invoice.total);
//    }
//
//    public void displayTotalNetto() {
//        System.out.println("Total: " + invoice.total);
//    }
//
//    public void displayTotalBrutto() {
//        System.out.println("Total: " + invoice.total);
//    }
}
