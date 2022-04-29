package com.example.gcbugger.domain.menu.domain;

public class BuggerCombo extends Menu {

    private final Bugger bugger;

    private Beverage beverage;

    private SideMenu sideMenu;

    public BuggerCombo(Long id, String name, int price, int kcal, Bugger bugger) {
        super(id, name, price, kcal);
        this.bugger = bugger;
    }
}
