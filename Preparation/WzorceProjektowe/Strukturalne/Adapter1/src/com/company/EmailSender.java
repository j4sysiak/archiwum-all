package com.company;

public class EmailSender implements INotificationSender {

    @Override
    public void sendNotification(int userId, Notification notification) {
        System.out.println("Sending email notification to " + userId + " : " + notification.Body);
    }
}
