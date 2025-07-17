package com.example.springbootac.application;

import com.example.springbootac.application.provided.MemberRegister;
import com.example.springbootac.application.required.EmailSender;
import com.example.springbootac.application.required.MemberRespository;
import com.example.springbootac.domain.Member;
import com.example.springbootac.domain.MemberRegisterRequest;
import com.example.springbootac.domain.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberRegister {
    private final MemberRespository memberRespository;
    private final EmailSender emailSender;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Member register(MemberRegisterRequest request) {
        // check
        Member member = Member.register(request, passwordEncoder);
        memberRespository.save(member);
        emailSender.send(member.getEmail(), "등록을 완료해 주세요", "아래 링크를 통해 등록 완료해 주세요");

        return member;
    }
}
