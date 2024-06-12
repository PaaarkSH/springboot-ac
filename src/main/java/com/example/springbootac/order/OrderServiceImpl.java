package com.example.springbootac.order;


import com.example.springbootac.discount.DiscountPolicy;
// import com.example.springbootac.discount.FixDiscountPolicy;
// import com.example.springbootac.discount.RateDiscountPolicy;
import com.example.springbootac.member.Member;
import com.example.springbootac.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
    @Autowired private MemberRepository memberRepository;
    @Autowired private DiscountPolicy discountPolicy;

//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        System.out.println("memberRepository = " + memberRepository);
//        System.out.println("discountPolicy = " + discountPolicy);
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
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
