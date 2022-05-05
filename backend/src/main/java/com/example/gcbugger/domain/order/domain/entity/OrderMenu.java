package com.example.gcbugger.domain.order.domain.entity;

import lombok.Getter;

@Getter
public class OrderMenu {

    private final Long id;
    private final Long orderId;
    private final Long menuId;
    private final Long menuOptionId;

    private OrderMenu(Long orderId, Long menuId, Long menuOptionId) {
        this(null, orderId, menuId, menuOptionId);
    }

    private OrderMenu(Long id, Long orderId, Long menuId, Long menuOptionId) {
        this.id = id;
        this.orderId = orderId;
        this.menuId = menuId;
        this.menuOptionId = menuOptionId;
    }

    public static OrderMenu create(Long orderId, Long menuId, Long menuOptionId) {
        return new OrderMenu(orderId, menuId, menuOptionId);
    }

    public static OrderMenu bind(Long id, Long orderId, Long menuId, Long menuOptionId) {
        return new OrderMenu(id, orderId, menuId, menuOptionId);
    }

}
