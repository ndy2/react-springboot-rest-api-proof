package com.example.gcbugger.domain.menu.domain.entity;

import lombok.Getter;

import static com.google.common.base.Preconditions.checkArgument;
import static org.springframework.util.StringUtils.hasText;

@Getter
public class MenuOption {

    private final Long id;

    private final MenuType menuType;

    private final String name;

    private final int price;

    public MenuOption(MenuType menu, String name, int price) {

        this(null, menu, name, price);
    }

    public MenuOption(Long id, MenuType menuType, String name, int price) {
        checkArgument(menuType != null, "menuType must be provided");
        checkArgument(hasText(name), "name must be provided");
        checkArgument(name.length() <= 50, "name length must be less than 50 inclusive");
        checkArgument(price >= 0, "price must non negative");

        this.id = id;
        this.menuType = menuType;
        this.name = name;
        this.price = price;
    }
}
