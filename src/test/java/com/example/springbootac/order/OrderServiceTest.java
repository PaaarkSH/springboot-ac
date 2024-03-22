package com.example.springbootac.order;

import com.example.springbootac.member.Grade;
import com.example.springbootac.member.Member;
import com.example.springbootac.member.MemberService;
import com.example.springbootac.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "MemberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000 );
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
