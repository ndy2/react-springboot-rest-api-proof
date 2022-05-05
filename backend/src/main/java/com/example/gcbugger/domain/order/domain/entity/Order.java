package com.example.gcbugger.domain.order.domain.entity;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalDateTime.now;

@Getter
public class Order {

    private final Long id;
    private final int price;
    private final List<OrderMenu> orderMenus;
    private final LocalDateTime createdAt;

    public Order(int price, List<OrderMenu> orderMenus) {
        this(null, price, orderMenus, now());
    }

    public Order(Long id, int price, List<OrderMenu> orderMenus, LocalDateTime createdAt) {
        this.id = id;
        this.price = price;
        this.orderMenus = orderMenus;
        this.createdAt = createdAt;
    }
}
