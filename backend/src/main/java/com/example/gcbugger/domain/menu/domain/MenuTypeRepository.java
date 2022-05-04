package com.example.gcbugger.domain.menu.domain;


import com.example.gcbugger.domain.menu.domain.entity.MenuType;

import java.util.List;

public interface MenuTypeRepository {
    List<MenuType> findAll();
}
