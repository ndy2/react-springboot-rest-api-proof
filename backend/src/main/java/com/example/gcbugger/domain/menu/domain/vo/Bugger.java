package com.example.gcbugger.domain.menu.domain.vo;

import static com.example.gcbugger.domain.menu.domain.MenuType.BUGGER;

public class Bugger extends Menu{

    public Bugger(String name, int price, int kcal) {
        super(BUGGER, name, price, kcal);
    }
}
