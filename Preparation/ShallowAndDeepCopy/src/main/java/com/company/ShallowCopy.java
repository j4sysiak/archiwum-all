package com.company;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShallowCopy {

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void whenModifyingOriginalObject_ThenCopyShouldChange() {

        Address address = new Address("Downing St 10", "London", "England");
        User pm = new User("Prime", "Minister", address);
        User shallowCopy = new User(pm.getFirstName(), pm.getLastName(), pm.getAddress());

        address.setCountry("Great Britain");
        Assert.assertNotEquals(shallowCopy, pm);
    }
}
