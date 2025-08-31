package com.company;

import org.testng.annotations.Test;

public class Client {

    @Test
    public void test() {
        /*
        Wszystkie zależności z wyskopoziomowych modułów ustalających politykę dla niskopoziomowych (nadrzędnych) modułów - są odwrócone.
        To właśnie dlatego tajniki implementacyjne wysokopoziomowych modułów są niezależne od sposobów implementacji dla niskopoziomowych modułów.
        Moduły wysokiego poziomu nie powinny zależeć od modułów niskiego poziomu.
        Oba powinny zależeć od abstrakcji np. interfejsów.
        Abstrakcje nie powinny zależeć od szczegółów.
        Szczegóły też powinny zależeć od abstrakcji.
        Zasada Odwócenia Zależności (Dependency Inversion Principle) - żeby klasy nie wiedziały o swoich tajnikach implementacyjnych
        ale nie chodzi o hermetyzację
        Obiekty powinny zależeć od abstrakcji a nie od typów.
*/

        //  just for testing ....
//        INotificationSender iem = new EmailNotification();
//        iem.sendNotification(User.builder()
//                .name("Marek Kowalski")
//                .email("test@wp.pl")
//                .password("test@wp.pl")
//                .phoneNumber("13579")
//                .build());

//        AuthenticationManager am1 = AuthenticationManager.builder()
//                .iNotificationSender(new EmailNotification())   //to się równa temu: INotificationSender iem = new EmailNotification();
//                .build();

//        AuthenticationManager am2 = AuthenticationManager.builder()
//                .iNotificationSender(new SmsNotification())
//                .build();


        // EmailNotification     - Moduł niskopoziomowy
        // AuthenticationManager - Moduł wysokopoziomowy
        AuthenticationManager.builder()
                //to się równa temu: INotificationSender iem = new EmailNotification();
                .iNotificationSender(new EmailNotification())  // tutaj wprowadzamy (wstrzykujemy) pośrednika (abstrakcję iNotificationSender) pomiedzy modulem wysokopoziomowym i niskopoziomowym
                .build()
                .authenticate(User.builder()
                                .name("Marek Kowalski")
                                .email("test@wp.pl")
                                .password("test@wp.pl")
                                .phoneNumber("13579")
                                .build(),
                        "test@wp.pl",
                        "test@wp.pl"
                );

        // SmsNotification       - Moduł niskopoziomowy
        // AuthenticationManager - Moduł wysokopoziomowy
        AuthenticationManager.builder()
                //to się równa temu: INotificationSender iem = new SmsNotification();
                .iNotificationSender(new SmsNotification())  // tutaj wprowadzamy (wstrzykujemy) pośrednika (abstrakcję iNotificationSender) pomiedzy modulem wysokopoziomowym i niskopoziomowym
                .build()
                .authenticate(User.builder()
                                .name("Jacek Nowak")
                                .email("test@wp.pl")
                                .password("test@wp.pl")
                                .phoneNumber("123456")
                                .build(),
                        "test@wp.pl",
                        "test@wp.pl"
                );
    }
}
