package com.example.springbootac.application.provided;


import com.example.springbootac.domain.Member;
import com.example.springbootac.domain.MemberRegisterRequest;

/**
 * 회원의 등록과 관계된 기능을 제공
 */

public interface MemberRegister {
    Member register(MemberRegisterRequest request);
}
