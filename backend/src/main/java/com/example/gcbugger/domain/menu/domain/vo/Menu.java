package com.example.gcbugger.domain.menu.domain.vo;

import com.example.gcbugger.domain.menu.domain.MenuType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public abstract class Menu {

    private final MenuType type;

    private final String name;

    private final int price;

    private final int kcal;

    public Menu(MenuType type, String name, int price, int kcal) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.kcal = kcal;
    }
}
