package com.company;

public interface IPanelFactory {

    //  Abstrakcyjna fabryka  / bazowy interfejs dla IButton i ITextbox

    /*
    Bazowy interface
    Abstrakcyjna fabryka, której zadanie będzie utworzenie bazowych elementów,
    bez konieczności znania ich implementacji konktretnych klas:
                            (nie wie co się dzieje w systemie Windows i Mac / jakie są implementacje)
    zdefiniowanie interfejsu dla dwóch metod: tworzenie przycisku: createButton() i tworzenie textboxu: createTextbox()
    Utworzenie bazowych elementów bez określania konieczności konkretnych klas:
    - dla tworzenia przycisku: MacButton czy WindowsButton
    - dla tworzenia Textboxa: MacTexbox czy WindowsTexbox
    ta abstrakcyjnan fabryka nie wie nic o systemie Windows, czy systemie Mac
    */

    IButton createButton();  // może dla Win a może dla Mac to zależey jak zbudowaliśmy Application tj. co wstrzyknęliśmy do konstruktora: new MacFactory() czy new WindowsFactory()

    ITextbox createTextbox();
}
