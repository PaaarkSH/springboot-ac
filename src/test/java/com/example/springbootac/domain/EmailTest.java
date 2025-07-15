package com.example.springbootac.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {
    @Test
    void emailEquality () {
        //given
        var email1 = new Email("test@google.com");
        var email2 = new Email("test@google.com");

        //when

        //then
        assertEquals(email1, email2);

    }
}