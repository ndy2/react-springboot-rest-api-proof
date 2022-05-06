package com.example.gcbugger.controller.order.dto;

import com.example.gcbugger.domain.order.domain.entity.OrderMenu;
import lombok.Data;

@Data
public class OrderMenuRequest {

    private Long menuId;
    private Long menuOptionId;
    private int price;

    public static OrderMenu toEntity(OrderMenuRequest orderMenuRequest) {

        return OrderMenu.create(orderMenuRequest.menuId, orderMenuRequest.menuOptionId, orderMenuRequest.price);
    }
}
