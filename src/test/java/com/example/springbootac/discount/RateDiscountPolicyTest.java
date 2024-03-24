package com.example.springbootac.discount;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 는 10% 할인이 적용 되어야 한다")
    void vip_o() {
        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        // when
        discountPolicy.discount(member, 10000);
        // then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP 는 10% 할인이 적용 되지 않아야 한다")
    void vip_x() {
        // given
        Member member = new Member(1L, "memberBasic", Grade.BASIC);
        // when
        discountPolicy.discount(member, 10000);
        // then
        assertThat(discount).isEqualTo(1000);
    }
}
