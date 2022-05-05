package com.example.gcbugger.domain.order.domain.entity;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static java.time.LocalDateTime.now;

@Getter
public class Order {

    private final Long id;
    private final int price;
    private final List<OrderMenu> orderMenus;
    private final LocalDateTime createdAt;

    private Order(List<OrderMenu> orderMenus) {
        this(null, retrievePrice(orderMenus), orderMenus, now());
    }

    private Order(Long id, int price, List<OrderMenu> orderMenus, LocalDateTime createdAt) {
        checkArgument(price >=0, "price must be none negative");
        checkOrderMenus(orderMenus);
        checkArgument(createdAt != null, "createdAt must be provided");

        this.id = id;
        this.price = price;
        this.orderMenus = orderMenus;
        this.createdAt = createdAt;
    }


    public static Order create(List<OrderMenu> orderMenus) {
        return new Order(orderMenus);
    }

    public static Order bind(Long id, int price, List<OrderMenu> orderMenus, LocalDateTime createdAt) {
        checkArgument(id != null, "id must be provided for binding");

        return new Order(id, price, orderMenus, createdAt);
    }

    public boolean isOfPrice(int price) {
        return this.price == price;
    }

    private static int retrievePrice(List<OrderMenu> orderMenus) {
        checkOrderMenus(orderMenus);

        return orderMenus.stream().map(OrderMenu::getPrice).mapToInt(i -> i).sum();
    }

    private static void checkOrderMenus(List<OrderMenu> orderMenus) {
        checkArgument(orderMenus != null, "orderMenus must be provided");
        checkArgument(orderMenus.size() > 0, "orderMenus must contain at least one orderMenu");
    }
}
