package com.example.springbootac.order;


import com.example.springbootac.discount.DiscountPolicy;
// import com.example.springbootac.discount.FixDiscountPolicy;
// import com.example.springbootac.discount.RateDiscountPolicy;
import com.example.springbootac.member.Member;
import com.example.springbootac.member.MemberRepository;
import com.example.springbootac.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
