package com.example.springbootac.application.required;

import com.example.springbootac.domain.Member;
import org.springframework.data.repository.Repository;

/**
 * 회원 정보를 저장하거나 조회한다
 * */

public interface MemberRespository extends Repository<Member, Long> {
    Member save(Member member);
}
