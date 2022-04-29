package com.example.gcbugger.domain.testutil;

import com.example.gcbugger.domain.menu.domain.entity.Menu;
import com.example.gcbugger.domain.menu.domain.entity.MenuOption;

import static com.example.gcbugger.domain.menu.domain.MenuType.*;

public class Fixture {

    /**
     * 메뉴
     */
    public static Menu bugger() {
        return new Menu( BUGGER, "불고기 버거",2000, 450);
    }

    public static Menu sideMenu() {
        return new Menu(SIDE_MENU, "감자 튀김", 1500, 300);
    }

    public static Menu beverage() {
        return new Menu(BEVERAGE, "제로 콜라", 1500, 0);
    }

    public static Menu buggerCombo() {
        return new Menu(BUGGER_COMBO, "불고기 버거 세트", 3500, 750);
    }

    /**
     * 메뉴 옵션
     */
    public static MenuOption buggerOption() {
        return new MenuOption(BUGGER, "피클을 빼줘", 0);
    }

    public static MenuOption buggerComboOption(){
        return new MenuOption(BUGGER_COMBO, "제로 콜라로 바꿔줘", 0);
    }
}
