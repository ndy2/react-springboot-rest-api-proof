package com.example.gcbugger.domain.menu.domain;

import com.example.gcbugger.domain.menu.domain.entity.Menu;
import com.example.gcbugger.domain.menu.domain.entity.MenuType;

import java.util.List;
import java.util.Optional;

public interface MenuRepository {

    List<Menu> findAll();

    List<Menu> findByType(MenuType type);

    Optional<Menu> findById(Long id);
}
