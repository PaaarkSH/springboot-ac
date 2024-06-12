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
    /*
    * 예상 시나리오
    * call AppConfig.memberService -> call AppConfig.memberRepository
    * call AppConfig.memberRepository
    * call AppConfig.orderService -> call AppConfig.memberRepository ->
    * */


    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
//        return new MemberServiceImpl(memberRepository());
        return null;
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
//        return new MemoryMemberRepository();
        return null;
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
//        return new OrderServiceImpl(
//                memberRepository(),
//                discountPolicy());
        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
