package com.example.gcbugger.domain.testutil;

import com.example.gcbugger.domain.menu.domain.vo.Beverage;
import com.example.gcbugger.domain.menu.domain.vo.Bugger;
import com.example.gcbugger.domain.menu.domain.vo.BuggerCombo;
import com.example.gcbugger.domain.menu.domain.vo.SideMenu;

public class Fixture {

    public static Bugger bugger() {
        return new Bugger("불고기 버거", 2000, 450);
    }

    public static SideMenu sideMenu() {
        return new SideMenu("감자 튀김", 1500, 300);
    }

    public static Beverage beverage() {
        return new Beverage("제로 콜라", 1500, 0);
    }

    public static BuggerCombo buggerCombo() {
        return new BuggerCombo("불고기 버거 세트", 3500, 750, bugger());
    }
}
