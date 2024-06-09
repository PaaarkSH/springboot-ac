package com.example.springbootac.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest  {

    @Test
    void statefullServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(StatefulService.class);
        StatefulService service1 = ac.getBean(StatefulService.class);
        StatefulService service2 = ac.getBean(StatefulService.class);

        // Thread A 사용자A 10000 원 주문
        // service1.order("userA", 10000);
        int userAPrice = service1.newOrder ("userA", 10000);

        // Thread A 사용자A 10000 원 주문
//        service2.order("userB", 20000);
        int userBPrice = service1.newOrder ("userB", 20000);

//        int price = service1.getPrice();
//        System.out.println("price: " + price);

//        Assertions.assertThat(service1.getPrice()).isEqualTo(20000);
        System.out.println("userAPrice: " + userAPrice) ;
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}