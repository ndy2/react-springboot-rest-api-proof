package com.example.gcbugger.domain.menu.service;

import com.example.gcbugger.domain.menu.domain.MenuRepository;
import com.example.gcbugger.domain.menu.domain.entity.Menu;
import com.example.gcbugger.domain.menu.domain.entity.MenuType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    public List<Menu> findByType(MenuType menuType) {
        return menuRepository.findByType(menuType);
    }

    public Menu findById(Long id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(MessageFormat.format("no such menu of id : {0}", id)));
    }
}
