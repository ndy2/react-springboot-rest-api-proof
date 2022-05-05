package com.example.gcbugger.domain.order.domain.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.gcbugger.domain.fixture.Fixture.order;
import static com.example.gcbugger.domain.fixture.Fixture.orderMenu;
import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OrderTest {

    List<OrderMenu> orderMenus = List.of(orderMenu(), orderMenu());

    @Test
    void 생성_성공() {
        Order createdOrder = Order.create(orderMenus);

        //then
        assertThat(createdOrder).isNotNull();
        assertThat(createdOrder.getId()).isNull();
        assertThat(createdOrder.getOrderMenus()).containsExactlyElementsOf(orderMenus);
        assertThat(createdOrder.getCreatedAt()).isNotNull();
        assertThat(createdOrder.getPrice()).isEqualTo(2000 + 2000);
    }

    @NullAndEmptySource
    @ParameterizedTest
    void null_혹은_빈_주문메뉴가_주어지면_생성_실패(List<OrderMenu> orderMenus) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Order.create(orderMenus));
    }

    @Test
    void 아이디와_생성시간을_바인딩하여_객체생성_성공() {
        //given
        LocalDateTime localDateTime = now();

        //when
        Order bindOrder = Order.bind(1L, 4000, orderMenus, localDateTime);

        //then
        assertThat(bindOrder).isNotNull();
        assertThat(bindOrder.getId()).isEqualTo(1L);
        assertThat(bindOrder.getOrderMenus()).containsExactlyElementsOf(orderMenus);
        assertThat(bindOrder.getPrice()).isEqualTo(4000);
        assertThat(bindOrder.getCreatedAt()).isEqualTo(localDateTime);
    }

    @Test
    void 아이디가_null_인경우_바인딩_실패() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Order.bind(null, 4000, orderMenus, now()));
    }

    @Test
    void 가격이_음수_인경우_바인딩_실패() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Order.bind(1L, -1, orderMenus, now()));
    }

    @NullAndEmptySource
    @ParameterizedTest
    void null_혹은_빈_주문메뉴가_주어지면_바인딩_실패(List<OrderMenu> orderMenus) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Order.bind(1L, 4000, orderMenus, now()));
    }

    @Test
    void 생성_일시가_null_이면_바인딩_실패() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Order.bind(1L, 4000, orderMenus, null));
    }

    @Test
    void 가격확인_같으면_true_다르면_false() {
        assertThat(order().isOfPrice(4000)).isTrue();
        assertThat(order().isOfPrice(4001)).isFalse();
    }
}