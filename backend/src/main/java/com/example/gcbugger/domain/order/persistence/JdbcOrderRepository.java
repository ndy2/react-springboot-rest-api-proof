package com.example.gcbugger.domain.order.persistence;

import com.example.gcbugger.domain.order.domain.OrderRepository;
import com.example.gcbugger.domain.order.domain.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static com.google.common.base.Preconditions.checkState;

@Repository
public class JdbcOrderRepository implements OrderRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final KeyHolder keyHolder;

    private static final String insertQuery = "INSERT INTO orders(order_price, created_at) VALUES (:orderPrice, :createdAt)";

    public JdbcOrderRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.keyHolder = new GeneratedKeyHolder();
    }

    @Override
    public Order insert(Order order) {
        int count = jdbcTemplate.update(insertQuery, toParamSource(order), keyHolder);
        checkState(count == 1, "amount of affected row of table orders caused by order insertion is not 1");

        order.setId(keyHolder.getKeyAs(Long.class));
        return order;
    }

    private SqlParameterSource toParamSource(Order order){
        return new MapSqlParameterSource(Map.<String, Object>of(
                "orderPrice", order.getPrice(),
                "createdAt", order.getCreatedAt()
        ));
    }
}
