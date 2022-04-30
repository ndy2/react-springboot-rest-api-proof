package com.example.gcbugger.domain.testutil;

import com.example.gcbugger.domain.menu.domain.entity.Menu;
import com.example.gcbugger.domain.menu.domain.entity.MenuOption;
import com.example.gcbugger.domain.menu.domain.entity.MenuType;


public class Fixture {

    /**
     * 메뉴 타입
     */
    public static MenuType buggerType(){
        return new MenuType(1L,"BUGGER");
    }

    public static MenuType buggerComboType(){
        return new MenuType(2L,"BUGGER_COMBO");
    }
    public static MenuType sideMenuType(){
        return new MenuType(3L,"SIDE_MENU");
    }

    public static MenuType beverageType(){
        return new MenuType(4L,"BEVERAGE");
    }


    /**
     * 메뉴
     */
    public static Menu bugger() {
        return new Menu(buggerType(), "불고기 버거",2000, 450);
    }

    public static Menu sideMenu() {
        return new Menu(sideMenuType(), "감자 튀김", 1500, 300);
    }

    public static Menu beverage() {
        return new Menu(beverageType(), "제로 콜라", 1500, 0);
    }

    public static Menu buggerCombo() {
        return new Menu(buggerComboType(), "불고기 버거 세트", 3500, 750);
    }

    /**
     * 메뉴 옵션
     */
    public static MenuOption buggerOption() {
        return new MenuOption(buggerType(), "피클을 빼줘", 0);
    }

    public static MenuOption buggerComboOption(){
        return new MenuOption(buggerComboType(), "제로 콜라로 바꿔줘", 0);
    }
}
