package com.company;

import lombok.Builder;

public class ValidationHandler extends BaseHandler {

    @Builder
    public ValidationHandler(IHandler next) {
        super(next);
    }

    @Override
    public void handle(RequestContext requestContext) {
        System.out.println("ValidationHandler");
        if (requestContext.request.entityId > 100) {
            super.next.handle(requestContext);
            return;
        }
        requestContext.response.isSuccessful = false;
        requestContext.response.message = "Validation error: EntityId must be grater then 100";
    }
}
