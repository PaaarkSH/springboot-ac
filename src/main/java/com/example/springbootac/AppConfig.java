package com.example.springbootac;

import com.example.springbootac.discount.DiscountPolicy;
import com.example.springbootac.discount.RateDiscountPolicy;
import com.example.springbootac.member.MemberRepository;
import com.example.springbootac.member.MemberService;
import com.example.springbootac.member.MemberServiceImpl;
import com.example.springbootac.member.MemoryMemberRepository;
import com.example.springbootac.order.OrderService;
import com.example.springbootac.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
