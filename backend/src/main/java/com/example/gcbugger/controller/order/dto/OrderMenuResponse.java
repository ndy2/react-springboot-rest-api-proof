package com.example.gcbugger.controller.order.dto;

import com.example.gcbugger.domain.order.domain.entity.OrderMenu;
import lombok.Data;

@Data
public class OrderMenuResponse {

    private final Long id;
    private final Long menuId;
    private final Long menuOptionId;
    private final int price;

    public static OrderMenuResponse of (OrderMenu om){
        return new OrderMenuResponse(om.getId(), om.getMenuId(), om.getMenuOptionId(), om.getPrice());
    }
}
