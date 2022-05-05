package com.example.gcbugger.domain.order.persistence;

import com.example.gcbugger.domain.order.domain.OrderRepository;
import com.example.gcbugger.domain.order.domain.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static com.google.common.base.Preconditions.checkState;

@Repository
@RequiredArgsConstructor
public class JdbcOrderRepository implements OrderRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private static final String insertQuery = "INSERT INTO orders(order_price, created_at) INTO values(:orderPrice, :createdAt)";

    @Override
    public Order insert(Order order) {
        int count = jdbcTemplate.update(insertQuery, toParamMap(order));

        checkState(count == 1, "amount of affected row of table orders caused by order insertion is not 1");
        return order;
    }

    private Map<String, Object> toParamMap(Order order) {

        return Map.of(
                "orderPrice", order.getPrice(),
                "createdAt", order.getCreatedAt()
        );
    }
}
