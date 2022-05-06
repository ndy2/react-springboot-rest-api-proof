package com.example.gcbugger.controller.order;

import com.example.gcbugger.controller.order.dto.OrderMenuRequest;
import com.example.gcbugger.controller.order.dto.OrderRequest;
import com.example.gcbugger.controller.order.dto.OrderResponse;
import com.example.gcbugger.domain.order.domain.OrderType;
import com.example.gcbugger.domain.order.domain.entity.Order;
import com.example.gcbugger.domain.order.domain.entity.OrderMenu;
import com.example.gcbugger.domain.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public OrderResponse order(@RequestBody OrderRequest orderRequest) {
        OrderType orderType = OrderType.valueOf(orderRequest.getOrderType());
        int price = orderRequest.getPrice();
        List<OrderMenu> orderMenus = orderRequest.getOrderMenus().stream().map(OrderMenuRequest::toEntity).collect(Collectors.toList());

        Order order = orderService.createOrder(orderType, price, orderMenus);
        return OrderResponse.of(order);
    }
}
