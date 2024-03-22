package com.example.springbootac.order;


import com.example.springbootac.discount.DiscountPolicy;
import com.example.springbootac.discount.FixDiscountPolicy;
import com.example.springbootac.member.Member;
import com.example.springbootac.member.MemberRepository;
import com.example.springbootac.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
