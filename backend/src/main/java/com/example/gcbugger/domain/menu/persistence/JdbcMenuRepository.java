package com.example.gcbugger.domain.menu.persistence;

import com.example.gcbugger.domain.menu.domain.MenuRepository;
import com.example.gcbugger.domain.menu.domain.MenuType;
import com.example.gcbugger.domain.menu.domain.entity.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JdbcMenuRepository implements MenuRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private static final String findAllQuery = "SELECT * FROM menu";
    private static final String findByTypeQuery = "SELECT * FROM menu WHERE type= :type";
    private static final String findByTypeAndNameQuery = "SELECT * FROM menu WHERE type= :type and name= :name";


    @Override
    public List<Menu> findAll() {
        return jdbcTemplate.query(findAllQuery, menuRowMapper);
    }

    @Override
    public List<Menu> findByType(MenuType type) {
        Map<String, Object> paramMap = Collections.singletonMap("type", type.toString());
        return jdbcTemplate.query(findByTypeQuery, paramMap, menuRowMapper);
    }

    @Override
    public Optional<Menu> findByTypeAndName(MenuType type, String name) {
        try {
            Map<String, Object> paramMap = Map.of("type", type.toString(), "name", name);
            return Optional.of(jdbcTemplate.queryForObject(findByTypeAndNameQuery, paramMap, menuRowMapper));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    private static final RowMapper<Menu> menuRowMapper = (rs, i) -> new Menu(
            rs.getLong("menu_id"),
            MenuType.valueOf(rs.getString("type")),
            rs.getString("name"),
            rs.getInt("price"),
            rs.getInt("kcal"));
}
