package com.example.gcbugger.domain.order.persistence;

import com.example.gcbugger.domain.order.domain.entity.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import static com.example.gcbugger.domain.fixture.Fixture.order;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DataJdbcTest
class JdbcOrderRepositoryTest {

    @Autowired NamedParameterJdbcTemplate jdbcTemplate;
    JdbcOrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository = new JdbcOrderRepository(jdbcTemplate);
    }

    @Test
    void 성공_삽입(){
        Order order = order();

        Order insertedOrder = orderRepository.insert(order);

        assertThat(insertedOrder).isNotNull();
        assertThat(insertedOrder.getId()).isNotNull();
        assertThat(insertedOrder.getPrice()).isEqualTo(4000);
        assertThat(insertedOrder.getOrderMenus()).containsExactlyElementsOf(order.getOrderMenus());
        assertThat(insertedOrder.getCreatedAt()).isNotNull();
    }

    @Test
    void 삽입_두번해도_아이디_잘만들어줌_Auto_Increment(){
        Order insertedOrder1 = orderRepository.insert(order());
        Order insertedOrder2 = orderRepository.insert(order());

        Long id1 = insertedOrder1.getId();
        Long id2 = insertedOrder2.getId();

        assertThat(id1).isNotNull();
        assertThat(id2).isNotNull();
        assertThat(id2).isEqualTo(id1+1);
    }

    @Test
    void 업데이트_결과가_1이아니면_이면_에외발생() {
        jdbcTemplate = mock(NamedParameterJdbcTemplate.class);
        when(jdbcTemplate.update(any(), any(), any())).thenReturn(0);
        orderRepository = new JdbcOrderRepository(jdbcTemplate);

        assertThatIllegalStateException()
                .isThrownBy(() -> orderRepository.insert(order()));
    }
}