package com.example.springbootac.adapter.integration;

import com.example.springbootac.domain.Email;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.StdIo;
import org.junitpioneer.jupiter.StdOut;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DummyEmailSenderTest {

    @Test
    @StdIo
    void dummyEmailSender(StdOut out) {
        DummyEmailSender dummyEmailSender = new DummyEmailSender();
        dummyEmailSender.send(new Email("test@google.com"), "Test Subject", "Test Body");
        assertThat(out.capturedLines()[0])
                .isEqualTo("DummyEmailSender: Email[address=test@google.com]");

    }
}