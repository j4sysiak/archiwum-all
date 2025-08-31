package com.company;

import org.junit.Test;

/*
    Strukturalny wzorzec projektowy, którego celem jest umożliwienie współpracy dwóm klasom o niekompatybilnych interfejsach.
    Adapter przekształca interface jednej klasy na interfejs drugiej klasy.
    Czyli zadaniem adaptera jest "Opakowanie" jednego interfejsu w nowy interfejs.
*/

public class ClientTest {
    @Test
    public void test() {

        //dostanie się do zewnętrznej bibioteki wysyłającej SMS SmsSender
        INotificationSender adapter1 = new SmsSenderAdapter();
        adapter1.sendNotification(1000, Notification.builder()
                .Title("TestTitle1")
                .Body("TestBody1")
                .build());


        // korzysta z wewnętrznej metody: sendNotification w klasie EmailSender
                 INotificationSender adapter2 = new EmailSender();
        adapter1.sendNotification(1001, Notification.builder()
                .Title("TestTitle1")
                .Body("TestBody1")
                .build());

        // korzysta z wewnętrznej metody: sendNotification w klasie PushSender
        INotificationSender adapter3 = new PushSender();
        adapter2.sendNotification(1002, Notification.builder()
                .Title("TestTitle2")
                .Body("TestBody2")
                .build());
    }
}
