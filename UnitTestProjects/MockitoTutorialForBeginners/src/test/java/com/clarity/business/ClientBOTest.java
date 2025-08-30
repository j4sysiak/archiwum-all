package com.clarity.business;

import com.in28minutes.junit.business.ClientBO;
import com.in28minutes.junit.business.ClientBOImpl;
import com.in28minutes.junit.business.exception.DifferentCurrenciesException;
import com.in28minutes.junit.model.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ClientBOTest {

    private ClientBO clientBO = new ClientBOImpl();

    @Test
    public void testClientProductSum() throws DifferentCurrenciesException {

        List<Product> products = new ArrayList<>();

        products.add(new ProductImpl(100, "Product 15",
                ProductType.BANK_GUARANTEE, new AmountImpl(
                new BigDecimal("5.0"), Currency.EURO)));

        products.add(new ProductImpl(120, "Product 20",
                ProductType.BANK_GUARANTEE, new AmountImpl(
                new BigDecimal("6.0"), Currency.EURO)));

        Amount amount = clientBO.getClientProductsSum(products);

        assertEquals(Currency.EURO, amount.getCurrency());
        assertEquals(new BigDecimal("11.0"), amount.getValue());
    }

    @Test(expected = DifferentCurrenciesException.class)
    public void testClientProductSum1() throws DifferentCurrenciesException {

        List<Product> products = new ArrayList<>();

        products.add(new ProductImpl(100, "Product 15",
                ProductType.BANK_GUARANTEE, new AmountImpl(
                new BigDecimal("5.0"), Currency.INDIAN_RUPEE)));

        products.add(new ProductImpl(120, "Product 20",
                ProductType.BANK_GUARANTEE, new AmountImpl(
                new BigDecimal("6.0"), Currency.EURO)));

        @SuppressWarnings("unused")
        Amount amount = null;

        when(clientBO.getClientProductsSum(products)).thenThrow(new DifferentCurrenciesException());

        //amount = clientBO.getClientProductsSum(products);
    }

    @Test
    public void testClientProductSum2() {

        List<Product> products = new ArrayList<>();

        Amount amount = null;

        try {
            amount = clientBO.getClientProductsSum(products);
        } catch (DifferentCurrenciesException e) {
        }
        assertEquals(Currency.EURO, amount.getCurrency());
        assertEquals(BigDecimal.ZERO, amount.getValue());
    }

}