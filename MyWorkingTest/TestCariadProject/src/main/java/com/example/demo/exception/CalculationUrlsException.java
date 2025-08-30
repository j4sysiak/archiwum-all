package com.example.demo.exception;

public
class CalculationUrlsException extends RuntimeException {
    public
    CalculationUrlsException(String methodN, Throwable cause) {
        super(String.format("Error while invoking: ", methodN), cause);
    }
}
