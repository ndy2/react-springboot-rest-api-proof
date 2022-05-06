package com.example.gcbugger.controller.order.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    private final int price;
    private final List<OrderMenuRequest> orderMenus;

}
