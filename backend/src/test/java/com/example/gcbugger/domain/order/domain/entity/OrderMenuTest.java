package com.example.gcbugger.domain.order.domain.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OrderMenuTest {

    @Test
    void 생성_성공() {
        OrderMenu orderMenu = OrderMenu.create(2L, 3L, 2000);

        assertThat(orderMenu).isNotNull();
        assertThat(orderMenu.getId()).isNull();
        assertThat(orderMenu.getMenuId()).isEqualTo(2L);
        assertThat(orderMenu.getMenuOptionId()).isEqualTo(3L);
        assertThat(orderMenu.getPrice()).isEqualTo(2000);
    }

    @Test
    void 메뉴옵션이_null_이어도_생성_성공() {
        OrderMenu orderMenu = OrderMenu.create(2L, null, 2000);

        assertThat(orderMenu).isNotNull();
        assertThat(orderMenu.getId()).isNull();
        assertThat(orderMenu.getMenuId()).isEqualTo(2L);
        assertThat(orderMenu.getMenuOptionId()).isNull();
        assertThat(orderMenu.getPrice()).isEqualTo(2000);
    }

    @Test
    void 메뉴_아이디가_null_이면_생성_실패() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> OrderMenu.create(null, 3L, 2000));
    }

    @Test
    void 가격이_음수면_생성_실패() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> OrderMenu.create(2L, 3L, -1));
    }

    @Test
    void 바인딩_성공() {
        OrderMenu orderMenu = OrderMenu.bind(0L, 2L, 3L, 2000);

        assertThat(orderMenu).isNotNull();
        assertThat(orderMenu.getId()).isEqualTo(0L);
        assertThat(orderMenu.getMenuId()).isEqualTo(2L);
        assertThat(orderMenu.getMenuOptionId()).isEqualTo(3L);
        assertThat(orderMenu.getPrice()).isEqualTo(2000);
    }

    @Test
    void 메뉴옵션이_null_이어도_바인딩_성공() {
        OrderMenu orderMenu = OrderMenu.bind(0L, 2L, null, 2000);

        assertThat(orderMenu).isNotNull();
        assertThat(orderMenu.getId()).isEqualTo(0L);
        assertThat(orderMenu.getMenuId()).isEqualTo(2L);
        assertThat(orderMenu.getMenuOptionId()).isNull();
        assertThat(orderMenu.getPrice()).isEqualTo(2000);
    }

    @Test
    void 아이디가_null_이면_바인딩_실패() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> OrderMenu.bind(null, 2L, 3L, 2000));
    }

    @Test
    void 메뉴_아이디가_null_이면_바인딩_실패() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> OrderMenu.bind(0L, null, 3L, 2000));
    }

    @Test
    void 가격이_음수면_바인딩_실패() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> OrderMenu.bind(0L, 2L, 3L, -1));
    }

}