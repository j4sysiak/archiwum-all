package com.company.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class User {
    public String name;
    public String email;
    public String password;
    public String phoneNumber;
}
