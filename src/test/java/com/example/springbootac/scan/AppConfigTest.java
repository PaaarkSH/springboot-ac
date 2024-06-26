package com.example.springbootac.scan;

import com.example.springbootac.AppConfig;
import com.example.springbootac.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AppConfigTest  {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext  ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
