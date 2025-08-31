package com.company;

public class Application {

    /*
      Będzie bazować na interfejsie IPanelFactory  (abstrakcyjna Faktoria)
      Dostarczymy tutaj konkretną implementację poprzez wstrzyknięcie  abstrakcyjnej fabryki (Dependency Injection).
      Przekazując interfejs (abstrakcyjna Faktoria) poprzez konstruktor, klasa Application nie będzie w stanie rozróżnić, czy tworzymy coś dla Maca, czy Windowsa.

      Zadaniem tej klasy, będzie utworzenie abstrakcyjnego panelu użytkownika i potem utworzenia konkretnych elementów niezależnie od systemu.
    */



    private IPanelFactory ipanelFactory;

    // wstrzykujemy przez konstruktor element, na którym bazujemy: abstrakcyjna Faktoria
    public Application(IPanelFactory iPanelFactory) {
        this.ipanelFactory = iPanelFactory;
    }

    /* tworzenie  Astrakcyjnego Panelu (abstrakcyjna Faktoria)  niezależnie od systemu: Mac czy Windows */

    public void createPanel() {
        //obsługa Buttonu - ale jeszcze nie wiem jakiego systemu/typu
        IButton createAbstractButton = ipanelFactory.createButton();  /*tutaj bazujemy jeszcze na abstrakcji, bo nie wiemy co przyjdzie tworzyć, element dla Windowsa, czy może Mac'a*/
        createAbstractButton.renderButton();
        createAbstractButton.handleClickButton();

        //obsługa Textbox - ale jeszcze nie wiem jakiego systemu/typu
        ITextbox createAbstractTextbox = ipanelFactory.createTextbox();  /*tutaj bazujemy jeszcze na abstrakcji bo nie wiemy co przyjdzie tworzyć, element dla Windowsa, czy może Mac'a*/
        createAbstractTextbox.renderTextbox();
        createAbstractTextbox.handleTextboxInput();
    }
}
