package com.company;

public class RegisterClientView implements IMediator {

    //to jest klasa mediatora

    private Checkbox checkbox;
    private Button button;
    private Input input;

    public RegisterClientView(Checkbox checkbox, Button button, Input input) {
        this.checkbox = checkbox;
        this.button = button;
        this.input = input;


        //pole iMediator w klasie Component jest protected
        this.checkbox.setIMediator(this);
        this.button.setIMediator(this);
        this.input.setIMediator(this);
    }

    @Override
    public void notify(Component objectSendingThisEvent, String $event) {
        if ($event == "checkboxSelected") {
            this.input.saveValue();     // przyszła notifikacja od checkboxa a to wywołuje zadanie dla inputu
        } else if ($event == "click") {
            this.checkbox.render();     // przyszła notifikacja od buttona  a to wywołuje zadanie dla checkboxa
        } else if ($event == "insertText") {
            this.button.render();       // przyszła notifikacja od inputu  a to wywołuje zadanie dla buttona
        }
    }
}
