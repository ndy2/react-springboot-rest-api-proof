package com.example.gcbugger.domain.menu.domain;

import com.example.gcbugger.domain.menu.domain.entity.MenuOption;

import java.util.List;

public interface MenuOptionRepository {

    List<MenuOption> findByMenuTypeId(Long menuTypeId);
}
