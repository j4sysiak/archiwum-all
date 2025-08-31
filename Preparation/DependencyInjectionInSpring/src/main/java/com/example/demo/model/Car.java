package com.example.demo.model;

import lombok.*;



// używana klasa wielokrotnie więc nie możemy używać jej jako beana 
// (@Component @RestControllers @Controller @Bean #Service etc.))
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class Car {

    // musi być konstruktor bezparametrowy żeby rest-api chodziło
    // muszą być też settery i gettery do wszystkich pól
    public Car() {}

    private String type;
    private String make;
}
