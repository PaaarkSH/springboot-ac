package com.example.springbootac.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.springbootac.domain.MemberFixture.createMemberRegisterRequest;
import static com.example.springbootac.domain.MemberFixture.createPasswordEncoder;
import static org.assertj.core.api.Assertions.*;

class MemberTest {
    Member member;
    PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        this.passwordEncoder = createPasswordEncoder();
        member = Member.register(createMemberRegisterRequest(), passwordEncoder);
    }



    @Test
    void registerMember() {
        assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);
    }

    // spotbug 사용하면 되니까 null check 제거

    @Test
    void activate (){
        //given

        //when
        member.activate();
        //then
        assertThat(member.getStatus()).isEqualTo(MemberStatus.ACTIVE);
    }



    @Test
    void deactivated () throws Exception{

        //given
        member.activate();

        //when
        member.deactivate();

        //then
        assertThat(member.getStatus()).isEqualTo(MemberStatus.DEACTIVATED);
    }

    @Test
    void verifyPassword () {
        assertThat(member.verifyPassword("secret", passwordEncoder)).isTrue();
        assertThat(member.verifyPassword("secret123", passwordEncoder)).isFalse() ;
    }

    @Test
    void changeNickname () {
        assertThat(member.getNickname()).isEqualTo("nick");
        member.changeNickname("charlie");
        assertThat(member.getNickname()).isEqualTo("charlie");
    }

    @Test
    void changePassword() {
        member.changePassword("verySecret", passwordEncoder);
        assertThat(member.verifyPassword("verySecret", passwordEncoder)).isTrue();
    }

    @Test
    void shouldBeActive() {
        assertThat(member.isActive()).isFalse();
        member.activate();
        assertThat(member.isActive()).isTrue();
        member.deactivate();
        assertThat(member.isActive()).isFalse();
    }
    @Test
    void invalidEmail () {
        //given

        //when
        assertThatThrownBy(
                () -> Member.register(createMemberRegisterRequest("invalid email"), passwordEncoder)
        ).isInstanceOf(IllegalArgumentException.class);

        Member.register(createMemberRegisterRequest(), passwordEncoder);

        //then
    }

}