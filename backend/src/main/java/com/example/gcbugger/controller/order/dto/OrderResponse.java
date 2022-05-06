package com.example.gcbugger.controller.order.dto;

import com.example.gcbugger.domain.order.domain.entity.Order;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
public class OrderResponse {

    private final Long id;
    private final String orderType;
    private final int price;
    private final List<OrderMenuResponse> orderMenus;
    private final LocalDateTime createdAt;

    public static OrderResponse of(Order order) {
        List<OrderMenuResponse> orderMenuResponses = order.getOrderMenus().stream().map(OrderMenuResponse::of).collect(toList());
        return new OrderResponse(order.getId(), order.getOrderType().name(), order.getPrice(), orderMenuResponses, order.getCreatedAt());
    }
}
