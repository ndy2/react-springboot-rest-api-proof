package com.example.gcbugger.domain.order.persistence;

import com.example.gcbugger.domain.order.domain.OrderMenuRepository;
import com.example.gcbugger.domain.order.domain.entity.OrderMenu;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcOrderItemRepository implements OrderMenuRepository {
    
    private final NamedParameterJdbcTemplate jdbcTemplate;
    
    @Override
    public void insertAll(Long orderId, List<OrderMenu> orderMenus) {

    }
}
