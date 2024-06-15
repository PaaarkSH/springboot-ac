package com.example.springbootac;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("test1");
        helloLombok.setAge(10);

        System.out.println(helloLombok.toString() );
    }
}
