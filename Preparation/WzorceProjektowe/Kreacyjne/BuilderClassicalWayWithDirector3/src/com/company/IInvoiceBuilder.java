package com.company;

public interface IInvoiceBuilder {

    void setVendor(String vendor);

    void setNote(String note);

    Invoice build();
}
