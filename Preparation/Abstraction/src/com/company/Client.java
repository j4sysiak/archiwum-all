package com.company;

public class Client {

    public static void main(String[] args) {

        var es = new EmailSender() {
            @Override
            public void sendEmail(String email, String title, String body) {
                super.sendEmail(email, title, body);
            }
        };

        es.sendEmail("jacek@wp.pl", "myMessage", "bla bla bla");

        /*jedyna publiczna metoda*/
        /* sendEmail(...) wywoła pozostałe metody private : te metody są już dla nas tylko abstrakcyjne */
       // EmailSender.create().sendEmail("jacek@wp.pl", "myMessage", "bla bla bla");
    }
}
