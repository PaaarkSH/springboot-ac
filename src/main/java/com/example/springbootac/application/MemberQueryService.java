package com.example.springbootac.application;

import com.example.springbootac.application.provided.MemberFinder;
import com.example.springbootac.application.required.MemberRespository;
import com.example.springbootac.domain.Member;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Transactional
@Validated
@RequiredArgsConstructor
public class MemberQueryService implements MemberFinder {

    private final MemberRespository memberRespository;
    @Override
    public Member find(Long memberId) {
        return memberRespository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다 id: " + memberId));
    }
}
