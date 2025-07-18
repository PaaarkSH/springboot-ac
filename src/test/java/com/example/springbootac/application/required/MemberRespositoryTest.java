package com.example.springbootac.application.required;

import com.example.springbootac.domain.Member;
import com.example.springbootac.domain.MemberFixture;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import static com.example.springbootac.domain.MemberFixture.*;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class MemberRespositoryTest {
    @Autowired
    private MemberRespository memberRespository;

    @Autowired
    EntityManager em;

    @Test
    void createMember() {
        Member member = Member.register(createMemberRegisterRequest(), createPasswordEncoder());
        assertThat(member.getId()).isNull();
        memberRespository.save(member);
        assertThat(member.getId()).isNotNull();

        em.flush();
    }

    @Test
    void duplicateEmailFail() {
        Member member = Member.register(createMemberRegisterRequest(), createPasswordEncoder());
        memberRespository.save(member);

        Member member2 = Member.register(createMemberRegisterRequest(), createPasswordEncoder());
        assertThatThrownBy(() -> memberRespository.save(member2))
                .isInstanceOf(DataIntegrityViolationException.class);
    }

}