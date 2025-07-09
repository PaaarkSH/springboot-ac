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

}