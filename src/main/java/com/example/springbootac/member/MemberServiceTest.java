package com.example.springbootac.member;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;



public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();
    @Test
    void join(){
        // given
        Member member = new Member(1L, "MemberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then


    }
}
