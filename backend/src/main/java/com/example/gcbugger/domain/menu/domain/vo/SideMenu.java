package com.example.gcbugger.domain.menu.domain.vo;


import static com.example.gcbugger.domain.menu.domain.MenuType.SIDE_MENU;

public class SideMenu extends Menu {

    public SideMenu(String name, int price, int kcal){
        super(SIDE_MENU, name, price, kcal);
    }

}
