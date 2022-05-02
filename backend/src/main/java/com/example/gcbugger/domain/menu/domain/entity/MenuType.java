package com.example.gcbugger.domain.menu.domain.entity;

import lombok.Getter;

@Getter
public class MenuType {

    private final Long id;
    private final String name;

    public MenuType(String name) {
        this(null, name);
    }

    public MenuType(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
