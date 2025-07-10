package com.example.springbootac.domain;

import org.springframework.lang.NonNull;

public class NotNullableRunner {



    public static void main(String[] args) {

        String s = null;
        print(s);
    }

    public static void print(@NonNull String s) {
        System.out.println("s = " + s);
    }
}
