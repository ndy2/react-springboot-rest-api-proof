package com.example.gcbugger.controller.order;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {

    private final int price;
    private final List<OrderMenuDto> orderMenus;



}
