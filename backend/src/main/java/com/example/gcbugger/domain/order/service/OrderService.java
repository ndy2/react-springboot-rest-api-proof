package com.example.gcbugger.domain.order.service;

import com.example.gcbugger.domain.order.domain.OrderMenuRepository;
import com.example.gcbugger.domain.order.domain.OrderRepository;
import com.example.gcbugger.domain.order.domain.entity.Order;
import com.example.gcbugger.domain.order.domain.entity.OrderMenu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMenuRepository orderMenuRepository;

    @Transactional
    public void createOrder(int price, List<OrderMenu> orderMenus) {
        Order order = Order.create(price, orderMenus);
        order = orderRepository.insert(order);
        orderMenuRepository.insertAll(order.getId(), orderMenus);
    }
}
