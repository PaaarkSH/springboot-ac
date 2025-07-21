package com.example.springbootac;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;

import static org.junit.jupiter.api.Assertions.*;


class SpringbootAcApplicationTest {
    @Test
    void run() {
        MockedStatic<SpringbootAcApplication> mocked = Mockito.mockStatic(SpringbootAcApplication.class);
        SpringbootAcApplication.main(new String[0]);
        mocked.verify(()-> SpringApplication.run(SpringbootAcApplication.class, new String[0]));
    }
}