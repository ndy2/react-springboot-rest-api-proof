package com.example.gcbugger.domain.order.domain.entity;

import com.example.gcbugger.domain.order.domain.OrderType;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static java.time.LocalDateTime.now;

@Getter
public class Order {

    private Long id;
    private final OrderType orderType;
    private final int price;
    private List<OrderMenu> orderMenus;
    private final LocalDateTime createdAt;

    private Order(OrderType orderType, List<OrderMenu> orderMenus) {
        this(null, orderType, retrievePrice(orderMenus), orderMenus, now());
    }

    private Order(Long id, OrderType orderType, int price, List<OrderMenu> orderMenus, LocalDateTime createdAt) {
        checkArgument(orderType != null, "orderType must be provided");
        checkArgument(price >= 0, "price must be none negative");
        checkOrderMenus(orderMenus);
        checkArgument(createdAt != null, "createdAt must be provided");

        this.id = id;
        this.orderType = orderType;
        this.price = price;
        this.orderMenus = orderMenus;
        this.createdAt = createdAt;
    }

    public static Order create(OrderType orderType, List<OrderMenu> orderMenus) {
        return new Order(orderType, orderMenus);
    }

    public static Order bind(Long id, OrderType orderType, int price, List<OrderMenu> orderMenus, LocalDateTime createdAt) {
        checkArgument(id != null, "id must be provided for binding");

        return new Order(id, orderType, price, orderMenus, createdAt);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void changeOrderMenus(List<OrderMenu> orderMenus) {
        this.orderMenus = orderMenus;
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
