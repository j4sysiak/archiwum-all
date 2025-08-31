package com.company;

import lombok.Builder;


public class ResultHandler extends BaseHandler {

    @Builder
    protected ResultHandler(IHandler next) {
        super(next);
    }

    @Override
    public void handle(RequestContext requestContext) {
        System.out.println("ResultHandler");
        requestContext.response.isSuccessful = true;
        requestContext.response.message = "OK";
        requestContext.response.data = "Return Some value";
    }
}
