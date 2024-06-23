package com.example.springbootac.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.*;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean bean1 = context.getBean(PrototypeBean.class);
        bean1.addCount();
        assertThat(bean1.getCount()).isEqualTo(1);

        PrototypeBean bean2 = context.getBean(PrototypeBean.class);
        bean2.addCount();
        assertThat(bean2  .getCount()).isEqualTo(1);

    }

    @Test
    void singletonClientUsePrototype() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);
        ClientBean bean1 = ac.getBean(ClientBean.class);
        int count1 = bean1.logic();
        assertThat(count1).isEqualTo(1);

        ClientBean bean2 = ac.getBean(ClientBean.class);
        int count2 = bean2 .logic();
        assertThat(count2).isEqualTo(2);
    }

    @Scope("singleton")
    static class ClientBean  {
        private final PrototypeBean prototypeBean;  // 생성 시점에 주입  // 그래서 계속 같은걸 사용

        @Autowired
        public ClientBean(PrototypeBean prototypeBean ) {
            this.prototypeBean = prototypeBean;
        }
//        @Autowired
//        ApplicationContext applicationContext;

        public int logic(){
//            PrototypeBean prototypeBean = applicationContext.getBean(PrototypeBean.class);
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }
    }

    @Scope("singleton")
    static class ClientBean2  {
        private final PrototypeBean prototypeBean;  // 생성 시점에 주입  // 그래서 계속 같은걸 사용

        @Autowired
        public ClientBean2(PrototypeBean prototypeBean ) {
            this.prototypeBean = prototypeBean;
        }
//        @Autowired
//        ApplicationContext applicationContext;

        public int logic(){
//            PrototypeBean prototypeBean = applicationContext.getBean(PrototypeBean.class);
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }
    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public int getCount() {
            return count;
        }

        public void addCount() {count++;}

        public void setCount(int count) {
            this.count = count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }

    }
}
