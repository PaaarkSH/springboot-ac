package com.example.springbootac;

import com.example.springbootac.discount.FixDiscountPolicy;
import com.example.springbootac.member.MemberService;
import com.example.springbootac.member.MemberServiceImpl;
import com.example.springbootac.member.MemoryMemberRepository;
import com.example.springbootac.order.OrderService;
import com.example.springbootac.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
