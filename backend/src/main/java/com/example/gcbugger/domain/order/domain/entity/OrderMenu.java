package com.example.gcbugger.domain.order.domain.entity;

import lombok.Getter;

import static com.google.common.base.Preconditions.checkArgument;

@Getter
public class OrderMenu {

    private final Long menuId;
    private final Long menuOptionId;
    private final int price;
    private Long id;

    private OrderMenu(Long menuId, Long menuOptionId, int price) {
        this(null, menuId, menuOptionId, price);
    }

    private OrderMenu(Long id, Long menuId, Long menuOptionId, int price) {
        checkArgument(menuId != null, "menuId be provided");
        checkArgument(price >= 0, "price must be none negative");

        this.id = id;
        this.menuId = menuId;
        this.menuOptionId = menuOptionId;
        this.price = price;
    }

    public static OrderMenu create(Long menuId, Long menuOptionId, int price) {
        return new OrderMenu(null, menuId, menuOptionId, price);
    }

    public static OrderMenu bind(Long id, Long menuId, Long menuOptionId, int price) {
        checkArgument(id != null, "id must be provided for binding");

        return new OrderMenu(id, menuId, menuOptionId, price);
    }

    public void setId(Long id) {
        this.id = id;
    }
}
