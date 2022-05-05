package com.example.gcbugger.domain.order.domain;

import com.example.gcbugger.domain.order.domain.entity.OrderMenu;

import java.util.List;

public interface OrderMenuRepository {
    void insertAll(Long orderId, List<OrderMenu> orderMenus);
}
