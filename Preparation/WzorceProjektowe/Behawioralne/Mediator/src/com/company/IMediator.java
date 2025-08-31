package com.company;

//interfejs klasy mediatora RegisterClientView

// Cel: notyfikacja komponentów
// sprawdzamy przesłany event
// button - "click"
// checkbox - checkboxSelected
// input - insertText
// o tym zdarzeniu powiadomimy inne komponenty metoda notify() - odnosi się do poszczególnych naszych klas input-checkbox-button
// wywołuje mwybrane metody w tych klasach, jeżeli wystąpiło dane zdarzenie.
// Klasa RegisterClientView implementuje metodę notify.
// Klasa (Interface) Component - zadaniem tej klasy jest ustawienie referencji do mediatora

public interface IMediator {

    void notify(Component objectSendingThisEvent, String $event);   //obiekt klasy Component z którego wychodzi komunikat np: Button
}
