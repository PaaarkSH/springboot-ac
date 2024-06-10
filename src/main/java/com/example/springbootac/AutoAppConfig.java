package com.example.springbootac;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = {Configuration.class})
        // 기존의 AppConfig 의 Configuration 자동 구성을 막기 위해 filter 사용
        // 보통 이렇게 사용하지 않음
)
public class AutoAppConfig  {
}
