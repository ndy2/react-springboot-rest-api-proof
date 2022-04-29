package com.example.gcbugger.domain.menu.domain.entity;

import com.example.gcbugger.domain.menu.domain.MenuType;
import lombok.Getter;

import static com.google.common.base.Preconditions.checkArgument;
import static org.springframework.util.StringUtils.hasText;

@Getter
public class Menu {

    private Long id;

    private final MenuType type;

    private final String name;

    private final int price;

    private final int kcal;

    public Menu(MenuType type, String name, int price, int kcal) {

        this(null, type, name, price, kcal);
    }

    public Menu(Long id, MenuType type, String name, int price, int kcal) {
        checkArgument(type != null, "type must be provided");
        checkArgument(hasText(name), "name must be provided");
        checkArgument(name.length() <= 50, "name length must be less than 50 inclusive");
        checkArgument(price >= 0, "price must non negative");
        checkArgument(kcal >= 0, "kcal must non negative");

        this.id = id;
        this.type = type;
        this.name = name;
        this.price = price;
        this.kcal = kcal;
    }
}
