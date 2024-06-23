package com.example.springbootac.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingleTonTest  {

    @Test
    void singtonBeanFind() {
        AnnotationConfigApplicationContext  ac = new AnnotationConfigApplicationContext(SingleTonBean.class);
        SingleTonBean bean1 = ac.getBean(SingleTonBean.class);
        SingleTonBean bean2 = ac.getBean(SingleTonBean.class);
        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);
        Assertions.assertThat(bean1).isSameAs(bean2);

        ac.close();
    }

    @Scope("singleton")
    static class SingleTonBean {

        @PostConstruct
        public void init() {
            System.out.println("SingleTonBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingleTonBean.destroy");
        }
    }
}
