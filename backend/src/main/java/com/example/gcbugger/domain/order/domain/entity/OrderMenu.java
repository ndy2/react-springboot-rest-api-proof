package com.example.gcbugger.domain.order.domain.entity;

import lombok.Getter;

@Getter
public class OrderMenu {

    private final Long id;
    private final Long orderId;
    private final Long menuId;
    private final Long menuOptionId;

    public OrderMenu(Long orderId, Long menuId, Long menuOptionId) {
        this(null, orderId, menuId, menuOptionId);
    }

    public OrderMenu(Long id, Long orderId, Long menuId, Long menuOptionId) {
        this.id = id;
        this.orderId = orderId;
        this.menuId = menuId;
        this.menuOptionId = menuOptionId;
    }
}
