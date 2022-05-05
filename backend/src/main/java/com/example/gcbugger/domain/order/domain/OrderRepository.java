package com.example.gcbugger.domain.order.domain;

import com.example.gcbugger.domain.order.domain.entity.Order;

public interface OrderRepository {

    Order insert(Order order);
}
