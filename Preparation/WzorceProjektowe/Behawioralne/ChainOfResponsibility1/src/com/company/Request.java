package com.company;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Request {
    public String userRole;
    public Integer userId;
    public Integer entityId;
}