package com.example.gcbugger.controller.menu;

import com.example.gcbugger.domain.menu.domain.entity.MenuOption;
import com.example.gcbugger.domain.menu.domain.entity.MenuType;
import lombok.Data;

@Data
public class MenuOptionResponse {
    private Long id;
    private MenuType menuType;
    private String name;
    private int price;

    public static MenuOptionResponse of(MenuOption menuOption){
        MenuOptionResponse response = new MenuOptionResponse();
        response.id = menuOption.getId();
        response.menuType = menuOption.getMenuType();
        response.name = menuOption.getName();
        response.price = menuOption.getPrice();
        return response;
    }
}
