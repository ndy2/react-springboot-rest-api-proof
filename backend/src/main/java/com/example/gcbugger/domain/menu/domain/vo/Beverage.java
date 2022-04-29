package com.example.gcbugger.domain.menu.domain.vo;

import static com.example.gcbugger.domain.menu.domain.MenuType.BEVERAGE;

public class Beverage extends Menu {

    public Beverage(String name, int price, int kcal){
        super(BEVERAGE, name, price, kcal);
    }

}
