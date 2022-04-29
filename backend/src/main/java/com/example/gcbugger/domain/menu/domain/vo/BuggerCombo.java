package com.example.gcbugger.domain.menu.domain.vo;

import static com.example.gcbugger.domain.menu.domain.MenuType.BUGGER_COMBO;

public class BuggerCombo extends Menu {

    private Bugger bugger;

    private Beverage beverage;

    private SideMenu sideMenu;

    public BuggerCombo(String name, int price, int kcal, Bugger bugger) {
        super(BUGGER_COMBO, name, price, kcal);
        this.bugger = bugger;
    }


}
