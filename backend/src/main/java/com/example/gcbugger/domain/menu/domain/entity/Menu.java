package com.example.gcbugger.domain.menu.domain.entity;

import lombok.Getter;

import static com.google.common.base.Preconditions.checkArgument;
import static org.springframework.util.StringUtils.hasText;

@Getter
public class Menu {

    private final Long id;

    private final MenuType type;

    private final String name;

    private final int price;

    private final int kcal;

    private final String imageFileName;

    private Menu(MenuType type, String name, int price, int kcal, String imageFileName) {

        this(null, type, name, price, kcal, imageFileName);
    }

    private Menu(Long id, MenuType type, String name, int price, int kcal, String imageFileName) {
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
        this.imageFileName = imageFileName;
    }

    public static Menu bind(Long id, MenuType type, String name, int price, int kcal, String imageFileName) {
        return new Menu(id, type, name, price, kcal, imageFileName);
    }

    public static Menu create(MenuType type, String name, int price, int kcal, String imageFileName) {
        return new Menu(type, name, price, kcal, imageFileName);
    }
}
