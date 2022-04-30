package com.example.gcbugger.controller.menu;

import com.example.gcbugger.domain.menu.domain.entity.MenuType;
import com.example.gcbugger.domain.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.example.gcbugger.controller.menu.MenuResponse.of;
import static java.util.stream.Collectors.*;

@RestController
@RequestMapping(value = "/api/v1/menu", produces = "application/json; charset=utf-8")
@RequiredArgsConstructor
public class MenuRestController {

    private final MenuService menuService;

    @GetMapping
    public List<MenuResponse> findList(@RequestBody(required = false) Map<String, String> map) {
        List<MenuResponse> result;

        if (map == null) {
            result = menuService.findAll().stream()
                    .map(MenuResponse::of)
                    .collect(toList());
        } else {
            MenuType type = new MenuType(map.get("menuType"));
            result = menuService.findByType(type).stream()
                    .map(MenuResponse::of)
                    .collect(toList());
        }
        return result;
    }

    @GetMapping("/{id}")
    public MenuResponse findById(@PathVariable Long id){
        return of(menuService.findById(id));
    }

}
