package com.example.gcbugger.domain.menu.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class MenuType {

    private final Long id;
    private final String name;

    private MenuType(String name) {
        this(null, name);
    }

    private MenuType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static MenuType create(String name) {
        return new MenuType(name);
    }


    public static MenuType bind(Long id, String name) {
        return new MenuType(id, name);
    }
}
