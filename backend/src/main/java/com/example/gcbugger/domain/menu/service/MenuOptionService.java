package com.example.gcbugger.domain.menu.service;

import com.example.gcbugger.domain.menu.domain.MenuOptionRepository;
import com.example.gcbugger.domain.menu.domain.MenuType;
import com.example.gcbugger.domain.menu.domain.entity.MenuOption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuOptionService {

    private final MenuOptionRepository menuOptionRepository;

    public List<MenuOption> findByType(MenuType menuType) {
        return menuOptionRepository.findByMenuType(menuType);
    }

}
