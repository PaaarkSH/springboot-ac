package com.example.springbootac.member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
