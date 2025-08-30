package com.in28minutes.junit.business;

import com.in28minutes.junit.business.exception.DifferentCurrenciesException;
import com.in28minutes.junit.model.Amount;
import com.in28minutes.junit.model.Product;

import java.util.List;

public interface ClientBO {

    Amount getClientProductsSum(List<Product> products)
            throws DifferentCurrenciesException;

}
