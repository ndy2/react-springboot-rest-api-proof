package com.example.gcbugger.domain.menu.service;

import com.example.gcbugger.domain.menu.domain.entity.MenuType;
import com.example.gcbugger.domain.menu.persistence.JdbcMenuTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuTypeService {

    private final JdbcMenuTypeRepository menuTypeRepository;

    public List<MenuType> findAll() {
        return menuTypeRepository.findAll();
    }
}
