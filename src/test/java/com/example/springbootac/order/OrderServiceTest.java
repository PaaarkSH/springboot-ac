package com.example.springbootac.order;

import com.example.springbootac.AppConfig;
import com.example.springbootac.discount.FixDiscountPolicy;
import com.example.springbootac.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "MemberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000 );
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    @Test
    void fieldInjectionTest() {
        OrderServiceImpl orderService1 = new OrderServiceImpl();
         orderService1.setMemberRepository(new MemoryMemberRepository());
        orderService1.setDiscountPolicy(new FixDiscountPolicy());

        orderService1.createOrder(1L, "itemA", 10000);
    }
}
