package com.example.gcbugger.domain.menu.persistence;

import com.example.gcbugger.domain.menu.domain.MenuOptionRepository;
import com.example.gcbugger.domain.menu.domain.MenuType;
import com.example.gcbugger.domain.menu.domain.entity.MenuOption;
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

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private static final String findByMenuTypeQuery = "SELECT * FROM menu_option WHERE menu_type= :menuType";

    @Override
    public List<MenuOption> findByMenuType(MenuType menuType) {

        Map<String, Object> paramMap = Collections.singletonMap("menuType", menuType.toString());
        return jdbcTemplate.query(findByMenuTypeQuery, paramMap, menuOptionRowMapper);
    }

    private static final RowMapper<MenuOption> menuOptionRowMapper = (rs, i) -> new MenuOption(
            rs.getLong("menu_option_id"),
            MenuType.valueOf(rs.getString("menu_type")),
            rs.getString("name"),
            rs.getInt("price")
    );
}
