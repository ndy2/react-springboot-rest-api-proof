package com.example.gcbugger.domain.order.domain;

import com.example.gcbugger.domain.order.domain.entity.OrderMenu;

import java.util.List;

public interface OrderMenuRepository {
    List<OrderMenu> insertAll(List<OrderMenu> orderMenus);

    OrderMenu insert(OrderMenu orderMenu);
}
