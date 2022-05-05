package com.example.gcbugger.domain.order.persistence;

import com.example.gcbugger.domain.order.domain.entity.Order;
import com.example.gcbugger.domain.order.domain.entity.OrderMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

import static com.example.gcbugger.domain.fixture.Fixture.order;
import static com.example.gcbugger.domain.fixture.Fixture.orderMenu;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DataJdbcTest
class JdbcOrderMenuRepositoryTest {

    @Autowired NamedParameterJdbcTemplate jdbcTemplate;
    JdbcOrderMenuRepository orderMenuRepository;
    Long orderId;

    @BeforeEach
    void setUp() {
        // -> fk 조건 때문에 아이디가 orderId 를 하나 삽입하고 아이디를 얻어옴
        orderId = new JdbcOrderRepository(jdbcTemplate).insert(order()).getId();
        orderMenuRepository = new JdbcOrderMenuRepository(jdbcTemplate);
    }

    @Test
    void 성공_삽입(){
        OrderMenu orderMenu = OrderMenu.create(2L, 3L, 2000);

        OrderMenu insertedOrderMenu = orderMenuRepository.insert(orderId, orderMenu);

        assertOrderMenu(insertedOrderMenu,2L, 3L, 2000);
    }

    @Test
    void 업데이트_결과가_1이아니면_이면_에외발생() {
        jdbcTemplate = mock(NamedParameterJdbcTemplate.class);
        when(jdbcTemplate.update(any(), any(), any())).thenReturn(0);
        orderMenuRepository = new JdbcOrderMenuRepository(jdbcTemplate);

        assertThatIllegalStateException()
                .isThrownBy(() -> orderMenuRepository.insert(orderId, orderMenu()));
    }

    @Test
    void 여러_주문_메뉴_한번에_삽입_성공(){
        OrderMenu orderMenu1 = OrderMenu.create(2L, 3L, 2000);
        OrderMenu orderMenu2 = OrderMenu.create(2L, 3L, 2000);
        List<OrderMenu> orderMenus = List.of(orderMenu1, orderMenu2);

        List<OrderMenu> insertedOrderMenus = orderMenuRepository.insertAll(orderId, orderMenus);

        insertedOrderMenus.forEach(om -> assertOrderMenu(om,2L, 3L, 2000));
    }

    private void assertOrderMenu(OrderMenu actual,  Long menuId, Long menuOptionId, int price) {
        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isNotNull();
        assertThat(actual.getMenuId()).isEqualTo(menuId);
        assertThat(actual.getMenuOptionId()).isEqualTo(menuOptionId);
        assertThat(actual.getPrice()).isEqualTo(price);
    }
}