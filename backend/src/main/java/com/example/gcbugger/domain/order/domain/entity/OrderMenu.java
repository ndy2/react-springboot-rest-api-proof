package com.example.gcbugger.domain.order.domain.entity;

import lombok.Getter;

import static com.google.common.base.Preconditions.checkArgument;

@Getter
public class OrderMenu {

    private Long id;
    private final Long orderId;
    private final Long menuId;
    private final Long menuOptionId;
    private final int price;

    private OrderMenu(Long orderId, Long menuId, Long menuOptionId, int price) {
        this(null, orderId, menuId, menuOptionId, price);
    }

    private OrderMenu(Long id, Long orderId, Long menuId, Long menuOptionId, int price) {
        checkArgument(orderId != null, "orderId be provided");
        checkArgument(menuId != null, "menuId be provided");
        checkArgument(price >= 0, "price must be none negative");

        this.id = id;
        this.orderId = orderId;
        this.menuId = menuId;
        this.menuOptionId = menuOptionId;
        this.price = price;
    }

    public static OrderMenu create(Long orderId, Long menuId, Long menuOptionId, int price) {
        return new OrderMenu(orderId, menuId, menuOptionId, price);
    }

    public static OrderMenu bind(Long id, Long orderId, Long menuId, Long menuOptionId, int price) {
        checkArgument(id != null, "id must be provided for binding");

        return new OrderMenu(id, orderId, menuId, menuOptionId, price);
    }

    public void setId(Long id) {
        this.id = id;
    }
}
