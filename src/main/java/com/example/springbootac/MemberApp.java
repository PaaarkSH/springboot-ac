package com.example.springbootac;

import com.example.springbootac.member.Grade;
import com.example.springbootac.member.Member;
import com.example.springbootac.member.MemberService;
import com.example.springbootac.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "MemberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member " + findMember);
    }
}
