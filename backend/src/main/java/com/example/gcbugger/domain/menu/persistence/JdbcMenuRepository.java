package com.example.gcbugger.domain.menu.persistence;

import com.example.gcbugger.domain.menu.domain.MenuRepository;
import com.example.gcbugger.domain.menu.domain.entity.Menu;
import com.example.gcbugger.domain.menu.domain.entity.MenuType;
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

    private static final String findAllQuery = "SELECT * FROM menu m LEFT JOIN menu_type t on m.menu_type_id=t.menu_type_id";
    private static final String findByTypeQuery = "SELECT * FROM menu WHERE menu_type_id= :typeId";
    private static final String findByTypeAndNameQuery = "SELECT * FROM menu WHERE menu_type_id= :typeId and name= :name";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Menu> findAll() {
        return jdbcTemplate.query(findAllQuery, menuRowMapper);
    }

    @Override
    public List<Menu> findByTypeId(Long typeId) {
        Map<String, Object> paramMap = Collections.singletonMap("typeId", typeId);
        return jdbcTemplate.query(findByTypeQuery, paramMap, menuRowMapper);
    }

    @Override
    public Optional<Menu> findByTypeIdAndName(Long typeId, String name) {
        try {
            Map<String, Object> paramMap = Map.of("typeId", typeId, "name", name);
            return Optional.of(jdbcTemplate.queryForObject(findByTypeAndNameQuery, paramMap, menuRowMapper));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    private static final RowMapper<Menu> menuRowMapper = (rs, i) -> new Menu(
            rs.getLong("menu_id"),
            new MenuType(rs.getLong("menu_type_id"), rs.getString("name")),
            rs.getString("name"),
            rs.getInt("price"),
            rs.getInt("kcal"));
}
