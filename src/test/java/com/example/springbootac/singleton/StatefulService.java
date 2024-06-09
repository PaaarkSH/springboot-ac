package com.example.springbootac.singleton;

public class StatefulService {

    private int price;  // 상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        this.price = price;  // 여기가 문제
    }

    public int getPrice() {
        return price;
    }

    // 지역변수를 사용하는 방법
    public int  newOrder(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        return price;
    }
}
