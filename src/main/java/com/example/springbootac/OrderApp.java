package com.example.springbootac;

import com.example.springbootac.member.Grade;
import com.example.springbootac.member.Member;
import com.example.springbootac.member.MemberService;
import com.example.springbootac.member.MemberServiceImpl;
import com.example.springbootac.order.Order;
import com.example.springbootac.order.OrderService;
import com.example.springbootac.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000 );
        System.out.println(order);
    }
}
