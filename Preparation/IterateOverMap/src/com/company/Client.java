package com.company;

import org.junit.jupiter.api.Test;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;


public class Client {
    static Map<Integer, byte[]> _cache = new Hashtable() {};
    static {
        _cache.put(100, new byte[]{1, 2, 34});
        _cache.put(101, new byte[]{2, 90, 77});
    }
/*
    entrySet() – returns a collection-view of the map, whose elements are from the Map.Entry class. The entry.getKey() method returns the key, and entry.getValue() returns the corresponding value
    keySet() – returns all keys contained in this map as a Set
    values() – returns all values contained in this map as a Set
*/


    @Test
    public void usingEntrySet() {
        for (Map.Entry<Integer, byte[]> entry : _cache.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    @Test
    public void usingKeySet() {
        for (Integer key : _cache.keySet()) {
            System.out.println(key + ":" + _cache.get(key));
        }
    }

    @Test
    public void iteratingOverValuesUsingValues() {
        for (byte [] value : _cache.values()) {
            System.out.println(value);
        }
    }

    @Test
    public void iterateUsingIteratorAndEntry() {
        Iterator<Map.Entry<Integer, byte[]>> iterator = _cache.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, byte[]> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    @Test
    public void iterateUsingIteratorAndKeySet() {
        Iterator<Integer> iterator = _cache.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println(key + ":" + _cache.get(key));
        }
    }

    @Test
    public void iterateUsingIteratorAndValues() {
        Iterator<byte[]> iterator = _cache.values().iterator();
        while (iterator.hasNext()) {
            byte[] bytes = iterator.next();
            System.out.println("value :" + bytes);
        }
    }

    @Test
    public void iterateUsingLambda() {
        _cache.forEach((k, v) -> System.out.println((k + ":" + v)));
    }

    @Test
    public void iterateByKeysUsingLambda() {
        _cache.keySet().forEach(k -> System.out.println((k + ":" + _cache.get(k))));
    }

    @Test
    public void iterateValuesUsingLambda() {
        _cache.values().forEach(v -> System.out.println(("value: " + v)));
    }

    @Test
    public void iterateUsingStreamAPI() {
        _cache.entrySet().stream()
                // ... some other Stream processings
                .forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
    }
}























