package com.example.gcbugger.domain.menu;

import com.example.gcbugger.domain.menu.domain.MenuType;
import com.example.gcbugger.domain.menu.domain.vo.Menu;
import com.example.gcbugger.domain.menu.domain.MenuRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcMenuRepository implements MenuRepository {

    @Override
    public List<Menu> findAll() {
        return null;
    }

    @Override
    public List<Menu> findByType(MenuType type) {
        return null;
    }

    @Override
    public Optional<Menu> findByTypeAndName(MenuType type, String name) {
        return Optional.empty();
    }
}
