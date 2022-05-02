package com.example.gcbugger.controller.menu;

import com.example.gcbugger.domain.menu.domain.entity.Menu;
import com.example.gcbugger.domain.menu.domain.entity.MenuOption;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class MenuResponse {
    private long id;
    private String type;
    private String name;
    private int price;
    private int kcal;

    private List<MenuOptionResponse> options;

    public static MenuResponse of(Menu menu, List<MenuOption> options) {

        MenuResponse response = new MenuResponse();
        response.id = menu.getId();
        response.type = menu.getType().getName();
        response.name = menu.getName();
        response.price = menu.getPrice();
        response.kcal = menu.getKcal();

        response.options = options.stream().map(MenuOptionResponse::of).collect(Collectors.toList());
        return response;
    }
}
