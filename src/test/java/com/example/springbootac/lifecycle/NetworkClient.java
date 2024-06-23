package com.example.springbootac.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
 
public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("url: " + this.url);
        connect();
        call("초기화 연결 메세지");
    }


    public void setUrl(String url) {
        this.url = url;
    }

    // 네트워크 시작시 호출
    public void connect() {
        System.out.println("connect url: " + this.url);
    }

    public void call(String message) {
        System.out.println("connect url: " + this.url + " message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: " + this.url);
    }

    @PostConstruct
    public void init() {
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close() {
        disconnect();
    }
}
