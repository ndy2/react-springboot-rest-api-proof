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
    private static final String findByTypeQuery = "SELECT * FROM menu m LEFT JOIN menu_type t on m.menu_type_id=t.menu_type_id WHERE menu_type_name= :typeName";
    private static final String findByIdQuery = "SELECT * FROM menu m LEFT JOIN menu_type t on m.menu_type_id=t.menu_type_id WHERE menu_id= :menuId";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Menu> findAll() {
        return jdbcTemplate.query(findAllQuery, menuRowMapper);
    }


    @Override
    public List<Menu> findByType(MenuType type) {
        Map<String, Object> paramMap = Collections.singletonMap("typeName", type.getName());
        return jdbcTemplate.query(findByTypeQuery, paramMap, menuRowMapper);
    }

    @Override
    public Optional<Menu> findById(Long id) {
        try {
            Map<String, Object> paramMap = Map.of("menuId", id);
            return Optional.of(jdbcTemplate.queryForObject(findByIdQuery, paramMap, menuRowMapper));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    private static final RowMapper<Menu> menuRowMapper = (rs, i) -> Menu.bind(
            rs.getLong("menu_id"),
            MenuType.bind(rs.getLong("menu_type_id"), rs.getString("menu_type_name")),
            rs.getString("menu_name"),
            rs.getInt("menu_price"),
            rs.getInt("menu_kcal"),
            rs.getString("menu_image_file_name"));
}
