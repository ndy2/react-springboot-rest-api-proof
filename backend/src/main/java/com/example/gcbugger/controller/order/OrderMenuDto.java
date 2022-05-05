package com.example.gcbugger.controller.order;

import com.example.gcbugger.domain.order.domain.entity.OrderMenu;

public class OrderMenuDto {

    private Long id;
    private Long orderId;
    private Long menuId;
    private MenuOptionDto menuOption;

    public static OrderMenu toEntity(OrderMenuDto dto){
        return OrderMenu.create(dto.orderId, dto.menuId, dto.menuOption.getId());
    }
}
