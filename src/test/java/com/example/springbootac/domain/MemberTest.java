package com.example.springbootac.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class MemberTest {
    Member member;
    PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        this.passwordEncoder = new PasswordEncoder() {
            @Override
            public String encode(String password) {
                return password.toUpperCase();
            }
            @Override
            public boolean matches(String password, String encodedPassword) {
                return encode(password).equals(encodedPassword);
            }
        };

        member = Member.create(new MemberCreateRequest("test@test.com", "nick", "secret"), passwordEncoder);
    }

    @Test
    void createMember() {
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
                () -> Member.create(new MemberCreateRequest("invalid", "nick", "secret"), passwordEncoder)
        ).isInstanceOf(IllegalArgumentException.class);

        Member.create(new MemberCreateRequest("test@google.com", "nick", "secret"), passwordEncoder);

        //then
    }
}