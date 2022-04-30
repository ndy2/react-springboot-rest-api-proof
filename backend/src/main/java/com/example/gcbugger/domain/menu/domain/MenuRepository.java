package com.example.gcbugger.domain.menu.domain;

import com.example.gcbugger.domain.menu.domain.entity.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuRepository {

    List<Menu> findAll();

    List<Menu> findByTypeId(Long typeId);

    Optional<Menu> findByTypeIdAndName(Long typeId, String name);
}
