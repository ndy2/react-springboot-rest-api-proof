package com.example.gcbugger.controller.menu;

import com.example.gcbugger.domain.menu.domain.entity.Menu;
import lombok.Data;

@Data
public class MenuResponse {
    private long id;
    private String type;
    private String name;
    private int price;
    private int kcal;


    public static MenuResponse of(Menu menu) {

        MenuResponse response = new MenuResponse();
        response.id = menu.getId();
        response.type = menu.getType().getName();
        response.name = menu.getName();
        response.price = menu.getPrice();
        response.kcal = menu.getKcal();
        return response;
    }
}
