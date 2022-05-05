package com.example.gcbugger.controller.order;

import com.example.gcbugger.domain.order.domain.entity.OrderMenu;
import com.example.gcbugger.domain.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;

    @PostMapping
    public OrderResponse order(OrderDto orderDto){

        int price = orderDto.getPrice();
        List<OrderMenu> orderMenus = orderDto.getOrderMenus().stream().map(OrderMenuDto::toEntity).collect(Collectors.toList());
        orderService.createOrder(price, orderMenus);

        return new OrderResponse();
    }
}
