package com.example.springbootac.discount;

import com.example.springbootac.member.Grade;

public class RateDiscountPolicy implements DiscountPolicy {
    
    private int discountPercent = 10;

    @Override{
    public int discount(Member member, int price){
        return 0;
    }

}
