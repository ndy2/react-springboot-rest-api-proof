package com.example.gcbugger.domain.testutil;

import com.example.gcbugger.domain.menu.domain.entity.Menu;
import com.example.gcbugger.domain.menu.domain.entity.MenuOption;
import com.example.gcbugger.domain.menu.domain.entity.MenuType;


public class Fixture {

    /**
     * 메뉴 타입
     */
    public static MenuType buggerType() {
        return MenuType.create("BUGGER");
    }

    public static MenuType buggerComboType() {
        return MenuType.create("BUGGER_COMBO");
    }

    public static MenuType sideMenuType() {
        return MenuType.create("SIDE_MENU");
    }

    public static MenuType beverageType() {
        return MenuType.create("BEVERAGE");
    }


    /**
     * 메뉴
     */
    public static Menu bugger() {
        return Menu.create(buggerType(), "불고기 버거", 2000, 450, "bugogi.png");
    }

    public static Menu sideMenu() {
        return Menu.create(sideMenuType(), "감자 튀김", 1500, 300, "gamtui.png");
    }

    public static Menu beverage() {
        return Menu.create(beverageType(), "제로 콜라", 1500, 0, "zerocoke.png");
    }

    public static Menu buggerCombo() {
        return Menu.create(buggerComboType(), "불고기 버거 세트", 3500, 750, "bulgogiSet.png");
    }

    /**
     * 메뉴 옵션
     */
    public static MenuOption buggerOption() {
        return MenuOption.create(buggerType(), "피클을 빼줘", 0);
    }

    public static MenuOption buggerComboOption() {
        return MenuOption.create(buggerComboType(), "제로 콜라로 바꿔줘", 0);
    }
}
