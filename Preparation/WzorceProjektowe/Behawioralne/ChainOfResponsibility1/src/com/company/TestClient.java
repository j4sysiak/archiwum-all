package com.company;

import org.junit.Test;

public class TestClient {

    @Test
    public void test() {

     var requestContext = RequestContext.builder()
             .request(Request.builder().entityId(101).userId(14).userRole("User").build())
             .response(Response.builder().build())
             .build();

        System.out.println("budujemy prosty łańcuch zależnoći");

        //definiujemy ogniwo_1
        ResultHandler resultHandler = ResultHandler.builder()
                .next(null)  // na początku nic nie wstrzykujemy do next ( czyli IHandler )
                .build();

        //definiujemy ogniwo 2
        var validationHandler = ValidationHandler.builder()
                .next(resultHandler)  // wstrzykujemy poprzednie  ogniwo_1 resultHandler (do next (IHandler))
                .build();

        //definiujemy ogniwo 3
        var authorizationHandler = AuthorizationHandler.builder()
                .next(validationHandler)  // wstrzykujemy poprzednie ogniwo_2 validationHandler (do next (IHandler))
                .build();

        // Start proces
        System.out.println("wywołanie procesu zaczynamy od wywołania pierwszego handlera, " +
                "czyli w klasie AuthorizationHandler (idziemy od góry na dół do ResultHandler)");
        authorizationHandler.handle(requestContext);

        System.out.println("IsSuccessful: " + requestContext.response.isSuccessful);
        System.out.println("Message: " + requestContext.response.message);
        System.out.println("Data: " + requestContext.response.data);
    }
}
