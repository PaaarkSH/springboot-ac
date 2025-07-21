package com.example.springbootac.application.provided;

import com.example.springbootac.SplearnTestConfiguration;
import com.example.springbootac.domain.Member;
import com.example.springbootac.domain.MemberFixture;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@Import(SplearnTestConfiguration.class)
record MemberFinderTest(MemberFinder memberFinder, MemberRegister memberRegister, EntityManager em) {
    @Test
    void find() {
        Member member = memberRegister.register(MemberFixture.createMemberRegisterRequest());
        em.flush();
        em.clear();

        Member found = memberFinder.find(member.getId());
        assertThat(found.getId()).isEqualTo(member.getId());
    }

    @Test
    void findFail() {
        Member found = memberFinder.find(999L);
        assertThatThrownBy(() -> memberFinder.find(999L))
                .isInstanceOf(IllegalArgumentException.class);

    }

}