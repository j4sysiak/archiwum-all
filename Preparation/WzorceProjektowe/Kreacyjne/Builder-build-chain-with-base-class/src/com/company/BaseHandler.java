package com.company;

public abstract class BaseHandler implements IHandler {

    protected IHandler next;

    protected BaseHandler(IHandler next) {
        this.next = next;
    }

    //@Override
    //public abstract void handle(RequestContext requestContext);
}
