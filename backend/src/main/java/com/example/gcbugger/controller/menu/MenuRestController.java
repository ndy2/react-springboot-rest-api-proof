package com.example.gcbugger.controller.menu;

import com.example.gcbugger.controller.menu.dto.MenuResponse;
import com.example.gcbugger.domain.menu.domain.entity.Menu;
import com.example.gcbugger.domain.menu.domain.entity.MenuOption;
import com.example.gcbugger.domain.menu.domain.entity.MenuType;
import com.example.gcbugger.domain.menu.service.MenuOptionService;
import com.example.gcbugger.domain.menu.service.MenuService;
import com.example.gcbugger.domain.menu.service.MenuTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.gcbugger.controller.menu.dto.MenuResponse.of;
import static java.util.stream.Collectors.toList;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/menu", produces = "application/json; charset=utf-8")
@RequiredArgsConstructor
public class MenuRestController {

    private final MenuService menuService;
    private final MenuTypeService menuTypeService;
    private final MenuOptionService menuOptionService;


    @GetMapping
    public List<MenuResponse> findAll() {
        log.info("MenuRestController.findAll");
        Map<MenuType, List<MenuOption>> map = new HashMap<>();
        for (MenuType menuType : menuTypeService.findAll()) {
            map.put(menuType, menuOptionService.findByMenuTypeId(menuType.getId()));
        }

        return menuService.findAll().stream()
                .map(m -> of(m, map.get(m.getType())))
                .collect(toList());
    }

    @GetMapping("/{id}")
    public MenuResponse findById(@PathVariable Long id) {
        log.info("MenuRestController.findById({})", id);
        Menu menu = menuService.findById(id);
        List<MenuOption> options = menuOptionService.findByMenuTypeId(menu.getType().getId());

        return of(menu, options);
    }

}
