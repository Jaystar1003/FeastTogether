package org.FeastTogether.email;


public interface EmailSender {
    void send(String to, String email);
}