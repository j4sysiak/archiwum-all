package com.company;

public abstract class Component {
    protected IMediator iMediator;

    // Dependency Injection poprzez settera
    public void setIMediator(IMediator iMediator) {
        this.iMediator = iMediator;
    }
}

// zadaniem tej klasy jest ustawienie referencji do mediatora
