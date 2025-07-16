package com.example.springbootac.application.required;

import com.example.springbootac.domain.Member;
import com.example.springbootac.domain.MemberFixture;
import com.example.springbootac.domain.MemberRegisterRequest;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRespositoryTest {
    @Autowired
    private MemberRespository memberRespository;

    @Autowired
    EntityManager em;

    @Test
    void createMember() {
        Member member = Member.register(MemberFixture.createMemberRegisterRequest(), MemberFixture.createPasswordEncoder());
    }

}