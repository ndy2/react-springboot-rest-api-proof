package com.example.gcbugger.domain.menu.persistence;

import com.example.gcbugger.domain.menu.domain.MenuTypeRepository;
import com.example.gcbugger.domain.menu.domain.entity.MenuType;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcMenuTypeRepository implements MenuTypeRepository {

    private static final String findAllQuery = "SELECT * FROM menu_type";
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<MenuType> findAll() {

        return jdbcTemplate.query(findAllQuery, menuTypeRowMapper);
    }

    private static final RowMapper<MenuType> menuTypeRowMapper = (rs, i) -> MenuType.bind(
            rs.getLong("menu_type_id"),
            rs.getString("menu_type_name")
    );

}
