package com.example.gcbugger.domain.menu.domain;

import lombok.Getter;

@Getter
public abstract class Menu {

    private final Long id;

    private final String name;

    private final int price;

    private final int kcal;

    public Menu(Long id, String name, int price, int kcal) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.kcal = kcal;
    }
}
