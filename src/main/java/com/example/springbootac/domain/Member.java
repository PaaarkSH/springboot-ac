package com.example.springbootac.domain;

import lombok.Getter;
import lombok.ToString;

import static org.springframework.util.Assert.*;

import java.util.Objects;

@Getter
@ToString
public class Member {
    private String email;
    private String nickname;
    private String passwordHash;
    private MemberStatus status;

    private Member(String email, String nickname, String passwordHash) {
        this.email = Objects.requireNonNull(email);
        this.nickname = Objects.requireNonNull(nickname);
        this.passwordHash = Objects.requireNonNull(passwordHash);
        this.status = MemberStatus.PENDING;
    }

    public static Member create(String email, String nickname, String passwordHash) {
        return new Member(email, nickname, passwordHash);
    }


    public void activate() {
        state(status == MemberStatus.PENDING, "PENDING 상태가 아닙니다");

        this.status = MemberStatus.ACTIVE;
    }

    public void deactivate() {
        state(status == MemberStatus.ACTIVE, "ACTIVE 상태가 아닙니다");
        
        this.status = MemberStatus.DEACTIVATED;
        
    }
}
