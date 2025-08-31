package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DeepCopy {

    @BeforeEach
    public void setUp() {
    }

    /*Copy Constructor*/
    @Test
    public void whenModifyingOriginalObject_thenCopyShouldNotChange() {
        Address address = new Address("Downing St 10", "London", "England");
        User pm = new User("Prime", "Minister", address);
        User deepCopy = new User(pm);

        address.setCountry("Great Britain");

        assertNotEquals(
                pm.getAddress().getCountry(),
                deepCopy.getAddress().getCountry());

        Assert.assertNotEquals(deepCopy, pm);
    }

    /*Cloneable Interface*/
    @Test
    public void whenModifyingOriginalObject_thenCloneCopyShouldNotChange() {
        Address address = new Address("Downing St 10", "London", "England");
        User pm = new User("Prime", "Minister", address);
        User deepCopy = (User) pm.clone();

        address.setCountry("Great Britain");

        assertNotEquals(deepCopy.getAddress().getCountry(), pm.getAddress().getCountry());
        Assert.assertNotEquals(deepCopy, pm);
    }

    /*
    JSON Serialization With Gson
    The other way to serialize is to use JSON serialization. Gson is a library that's used for converting objects into JSON and vice versa.
    Unlike Apache Commons Lang, GSON does not need the Serializable interface to make the conversions.
    */
    @Test
    public void whenModifyingOriginalObject_thenGsonCloneShouldNotChange() {
        Address address = new Address("Downing St 10", "London", "England");
        User pm = new User("Prime", "Minister", address);
        Gson gson = new Gson();
        User deepCopy = gson.fromJson(gson.toJson(pm), User.class);

        address.setCountry("Great Britain");

        assertNotEquals(deepCopy.getAddress().getCountry(), pm.getAddress().getCountry());
        Assert.assertNotEquals(deepCopy, pm);
    }

    /*
    JSON Serialization With Jackson
    Jackson is another library that supports JSON serialization.
    This implementation will be very similar to the one using Gson, but we need to add the default constructor to our classes.
    */
    @Test
    public void whenModifyingOriginalObject_thenJacksonCopyShouldNotChange()
            throws IOException {
        Address address = new Address("Downing St 10", "London", "England");
        User pm = new User("Prime", "Minister", address);
        ObjectMapper objectMapper = new ObjectMapper();

        User deepCopy = objectMapper
                .readValue(objectMapper.writeValueAsString(pm), User.class);

        address.setCountry("Great Britain");

        assertNotEquals(deepCopy.getAddress().getCountry(), pm.getAddress().getCountry());
        Assert.assertNotEquals(deepCopy, pm);
    }
}
