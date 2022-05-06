package com.example.gcbugger.domain.order.persistence;

import com.example.gcbugger.domain.order.domain.OrderMenuRepository;
import com.example.gcbugger.domain.order.domain.entity.OrderMenu;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkState;
import static java.util.stream.Collectors.*;

@Repository
public class JdbcOrderMenuRepository implements OrderMenuRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final KeyHolder keyHolder;

    private static final String insertQuery = "INSERT INTO order_menu(order_id, menu_id, menu_option_id, order_menu_price) VALUES(:orderId, :menuId, :menuOptionId, :orderMenuPrice)";

    public JdbcOrderMenuRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.keyHolder = new GeneratedKeyHolder();
    }

    @Override
    public List<OrderMenu> insertAll(Long orderId, List<OrderMenu> orderMenus) {
        return orderMenus.stream().map(orderMenu -> insert(orderId, orderMenu)).collect(toList());
    }

    @Override
    public OrderMenu insert(Long orderId, OrderMenu orderMenu){
        try {
            int count = jdbcTemplate.update(insertQuery, toParamSource(orderId, orderMenu), keyHolder);
            checkState(count == 1, "amount of affected row of table orders caused by order insertion is not 1");
        } catch (DataAccessException e) {
            throw new IllegalArgumentException(String.format("No such menuId : %d", orderMenu.getMenuId()), e);
        }

        orderMenu.setId(keyHolder.getKey().longValue());
        return orderMenu;
    }

    private SqlParameterSource toParamSource(Long orderId, OrderMenu orderMenu){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("orderId", orderId);
        paramMap.put("menuId", orderMenu.getMenuId());
        paramMap.put("menuOptionId", orderMenu.getMenuOptionId());
        paramMap.put("orderMenuPrice", orderMenu.getPrice());

        return new MapSqlParameterSource(paramMap);
    }
}
