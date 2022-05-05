package com.example.gcbugger.domain.order.domain;

import com.example.gcbugger.domain.order.domain.entity.OrderMenu;

import java.util.List;

public interface OrderMenuRepository {

    List<OrderMenu> insertAll(Long orderId, List<OrderMenu> orderMenus);

    OrderMenu insert(Long orderId, OrderMenu orderMenu);
}
