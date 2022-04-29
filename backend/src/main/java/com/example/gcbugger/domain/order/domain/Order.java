package com.example.gcbugger.domain.order.domain;

import com.example.gcbugger.domain.customer.domain.Customer;

import java.util.List;

public class Order {

    private Long id;
    private List<OrderItem> orderItems;
    private int price;
    private Customer customer;
}
