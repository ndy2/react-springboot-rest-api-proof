package com.example.gcbugger.domain.menu.persistence;

import com.example.gcbugger.domain.menu.domain.MenuOptionRepository;
import com.example.gcbugger.domain.menu.domain.entity.MenuOption;
import com.example.gcbugger.domain.menu.domain.entity.MenuType;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class JdbcMenuOptionRepository implements MenuOptionRepository {

    private static final String findByMenuTypeQuery = "SELECT * FROM menu_option  WHERE menu_type_id= :menuTypeId";
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<MenuOption> findByMenuTypeId(Long menuTypeId) {

        Map<String, Object> paramMap = Collections.singletonMap("menuTypeId", menuTypeId);
        return jdbcTemplate.query(findByMenuTypeQuery, paramMap, menuOptionRowMapper);
    }

    private static final RowMapper<MenuOption> menuOptionRowMapper = (rs, i) -> new MenuOption(
            rs.getLong("menu_option_id"),
            new MenuType(rs.getLong("menu_type_id"), rs.getString("name")),
            rs.getString("name"),
            rs.getInt("price")
    );
}
