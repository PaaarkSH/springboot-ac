package com.example.springbootac.application.provided;

import com.example.springbootac.domain.Member;

/**
 * 회원을 조회한다
 */
public interface MemberFinder {
    Member find(Long memberId);
}
