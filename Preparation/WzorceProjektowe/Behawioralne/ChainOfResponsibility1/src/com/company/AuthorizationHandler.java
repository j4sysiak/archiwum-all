package com.company;

import lombok.Builder;

import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;

public class AuthorizationHandler extends BaseHandler {

    // słownik definiuje jaki zasób dostępny dla danego usera
    // creating my HashTable Dictionary
    static Map<Integer, Integer> entityOwners = new Hashtable(){};


    static {
        entityOwners.put(100, 13);
        entityOwners.put(101, 14);
    }

    @Builder
    public AuthorizationHandler(IHandler next) {
        super(next);
    }

    @Override
    public void handle(RequestContext requestContext) {
        System.out.println("AuthorizationHandler");
        if (requestContext.request.userRole == "Admin") {
            super.next.handle(requestContext);  // obsługa idzie do następnego handlera (super)
            return;
        }
        // sprawdzamy, czy w słowniku istnieje taki obiekt
        if (Objects.equals(entityOwners.get(requestContext.request.entityId), requestContext.request.userId)) {
            super.next.handle(requestContext);
            return;
        }
        requestContext.response.isSuccessful = false;
        requestContext.response.message = "User is not authorized";
    }
}
