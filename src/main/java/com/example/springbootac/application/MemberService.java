package com.example.springbootac.application;

import com.example.springbootac.application.provided.MemberRegister;
import com.example.springbootac.application.required.EmailSender;
import com.example.springbootac.application.required.MemberRespository;
import com.example.springbootac.domain.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements MemberRegister {
    private final MemberRespository memberRespository;
    private final EmailSender emailSender;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Member register(MemberRegisterRequest request) {
        // check
        checkDuplicateEmail(request);

        Member member = Member.register(request, passwordEncoder);
        memberRespository.save(member);

        sendWelcomEmail(member);

        return member;
    }

    @Override
    public Member activate(Long memberId) {
        Member member = memberRespository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다 id: " + memberId));
        member.activate();
        return memberRespository.save(member);
    }

    private void sendWelcomEmail(Member member) {
        emailSender.send(member.getEmail(), "등록을 완료해 주세요", "아래 링크를 통해 등록 완료해 주세요");
    }

    private void checkDuplicateEmail(MemberRegisterRequest request) {
        if (memberRespository.findByEmail(new Email(request.email())).isPresent()) {
            throw new DuplicateEmailException("이미 사용중인 이메일 입니다: " + request.email());
        }
    }
}
