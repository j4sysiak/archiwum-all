package com.example.demo.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum EsbUrlMappingType {
    URL_ONE("http://example.com/primes"),
    URL_TWO("http://foobar.com/fibo"),
    URL_NOT_VALID("");
    private final String urlType;
}
