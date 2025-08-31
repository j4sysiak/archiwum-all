package com.company;

import com.company.model.User;

public class Client {

    public static void main(String[] args) {

/*
        Wszystkie zależności z wyskopoziomowych modułów ustalających politykę dla niskopoziomowych (nadrzędnych) modułów - są odwrócone.
        To właśnie dlatego tajniki implementacyjne wysokopoziomowych modułów są niezależne od sposobów implementacji dla niskopoziomowych modułów.
        Moduły wysokiego poziomu nie powinny zależeć od modułów niskiego poziomu.
        Oba powinny zależeć od abstrakcji np. interfejsów.
        Abstrakcje nie powinny zależeć od szczegółów.
        Szczegóły też powinny zależeć od abstrakcji.
        Zasada Odwócenia Zależności - żeby klasy nie wiedziały o swoich tajnikach implementacyjnych
        ale nie chodzi o hermetyzację
        Obiekty powinny zależeć od abstrakcji, a nie od typów.

        AuthenticationManager - moduł wysokiego poziomu
        EmailNotification - moduł niskiego poziomu
        SmsNotification - moduł niskiego poziomu
*/

        //EmailNotification
        AuthenticationManager.builder().iNotificationSender(new EmailNotification()).build().authenticate(
                User.builder().name("Marek Kowalski").email("test@wp.pl")
                        .password("test@wp.pl").phoneNumber("13579").build()
        );

        //SmsNotification
        AuthenticationManager.builder().iNotificationSender(new SmslNotification()).build().authenticate(
                User.builder().name("Jacek Nowak").email("test@wp.pl")
                        .password("test@wp.pl").phoneNumber("123456").build()
        );

    }
}
