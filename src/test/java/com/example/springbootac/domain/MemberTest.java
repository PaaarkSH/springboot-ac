package com.example.springbootac.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    @Test
    void createMember() {
        Member member = new Member("test@test.com", "nick", "secret");
        assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);
    }

    @Test
    void constructorNullCheck(){
        //given
        assertThatThrownBy(() -> new Member(null, null, null))
                .isInstanceOf(NullPointerException.class);
        //when

        //then
    }

    @Test
    void activate (){
        //given
        Member member = new Member("test@test.com", "nick", "secret");

        //when
        member.activate();
        //then
        assertThat(member.getStatus()).isEqualTo(MemberStatus.ACTIVE);
    }

    @Test
    void activateFail () {
        //given
        Member member = new Member("test@test.com", "nick", "secret");

        //when
        member.activate();

        //then
        assertThatThrownBy(() -> {

        }).isInstanceOf(IllegalStateException.class);
    }
    @Test
    void deactivated () throws Exception{

        //given
        Member member = new Member("test@test.com", "nick", "secret");
        member.activate();

        //when
        member.deactivate();

        //then
        assertThat(member.getStatus()).isEqualTo(MemberStatus.DEACTIVATED);
    }
}