package com.example.gcbugger.domain.order.persistence;

import com.example.gcbugger.domain.order.domain.OrderMenuRepository;
import com.example.gcbugger.domain.order.domain.entity.OrderMenu;

import java.util.List;

public class JdbcOrderItemRepository implements OrderMenuRepository {
    @Override
    public void insertAll(Long orderId, List<OrderMenu> orderMenus) {

    }
}
