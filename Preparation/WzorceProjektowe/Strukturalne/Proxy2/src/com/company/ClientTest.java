package com.company;

import org.junit.Test;

public class ClientTest {

    // Proxy - klasa pośrednik/pełnomocnik w wywołaniu właściwej metody
    // nasz ClientTest nie ma bezpośrednio dostępu do metod klasy ServiceImpl
    // ale za pośrednictwem klasy Proxy odpalamy metody w klasie ServiceImpl


    @Test
    public void test() {

        // nie stosujemy bezpośredniego strzału do metod ServiceImp
        //IService iService = new ServiceImpl(); l
        //iService.method();

        // w obiekcie Proxy tworzymy dopiero obiekt klasy ServiceImpl (lazy loading) - ponieważ nie musimy tego wcześniej robić i zabierać zasoby
        // tworzymy taki obiekt jak go potrzebujemy - przy wywołaniu jego metody (w warstwie pośredniej Proxy)
        IService iService = new Proxy();
        iService.method();
    }
}
