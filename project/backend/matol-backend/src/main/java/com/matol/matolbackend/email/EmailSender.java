package com.matol.matolbackend.email;

public interface EmailSender {

    void send(String to, String email);
}
