package com.company;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Response {
    public Boolean isSuccessful;
    public String message;
    public String data;
}
