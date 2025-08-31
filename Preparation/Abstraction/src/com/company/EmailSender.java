package com.company;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Builder
public abstract class EmailSender {

//    public static EmailSender create() {
//        return EmailSender.builder().build();
//    }

    /*jedyna publiczna metoda*/
    public void sendEmail(String email, String title, String body) {
        connectToSmtpServer();
        insertCredentials();
        sendMyEmail(email, title, body);
        disconnect();
    }

    private void sendMyEmail(String email, String title, String body) {
        System.out.println("sendMyEmail ..."  +":"+ email +":"+ title +":"+ body);
    }

    private void connectToSmtpServer() {
        System.out.println("ConnectToSmtpServer ...");
    }

    private void insertCredentials () {
        System.out.println("insertCredentials ...");
    }

    private void disconnect() {
        System.out.println("disconnect ...");
    }

}
