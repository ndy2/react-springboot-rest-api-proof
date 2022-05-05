package com.example.gcbugger.domain.order.service;

import com.example.gcbugger.domain.order.domain.entity.Order;
import com.example.gcbugger.domain.order.domain.entity.OrderMenu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {


    @Autowired OrderService orderService;
    List<OrderMenu> orderMenus;

    @BeforeEach
    void setUp() {
        //불고기버거 하나 + 빅맥 하나
        orderMenus = List.of(OrderMenu.create(1L, null, 2300),
                OrderMenu.create(2L, null, 4600));
    }


    @Test
    void 주문_성공(){
        Order order = orderService.createOrder(6900, orderMenus);

        assertThat(order).isNotNull();
        assertThat(order.getPrice()).isEqualTo(6900);
        assertThat(order.getCreatedAt()).isNotNull();

        assertThat(order.getOrderMenus()).extracting("id").doesNotContainNull();
        assertThat(order.getOrderMenus()).extracting("menuId").containsExactlyInAnyOrder(1L, 2L);
        assertThat(order.getOrderMenus()).extracting("menuOptionId").containsOnlyNulls();
        assertThat(order.getOrderMenus()).extracting("price").containsExactlyInAnyOrder(2300, 4600);
    }

    @Test
    void 주문_메뉴로_계산한_가격과_입력받은_가격이_다른경우_주문_실패(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> orderService.createOrder(6800, orderMenus));
    }
}