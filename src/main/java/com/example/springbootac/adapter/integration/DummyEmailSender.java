package com.example.springbootac.adapter.integration;

import com.example.springbootac.application.required.EmailSender;
import com.example.springbootac.domain.Email;
import org.springframework.stereotype.Component;

@Component
public class DummyEmailSender implements EmailSender {
    @Override
    public void send(Email email, String subject, String body) {
        System.out.println("DummyEmailSender: " + email);
    }
}
