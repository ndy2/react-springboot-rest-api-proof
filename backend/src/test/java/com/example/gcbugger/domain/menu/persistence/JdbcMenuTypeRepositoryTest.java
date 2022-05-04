package com.example.gcbugger.domain.menu.persistence;

import com.example.gcbugger.domain.menu.domain.entity.MenuType;
import com.example.gcbugger.domain.testutil.JdbcTestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringJUnitConfig
@ContextConfiguration(classes = JdbcTestConfig.class)
class JdbcMenuTypeRepositoryTest {

    @Autowired NamedParameterJdbcTemplate jdbcTemplate;
    JdbcMenuTypeRepository menuTypeRepository;

    @BeforeEach
    void setUp() {
        menuTypeRepository = new JdbcMenuTypeRepository(jdbcTemplate);
    }

    @Test
    void 성공_전체_조회(){
        //given
        //initial data (see schema.sql)

        //when
        List<MenuType> menuTypes = menuTypeRepository.findAll();

        //then
        assertThat(menuTypes).hasSize(4);
        assertThat(menuTypes).extracting("name")
                .containsExactlyInAnyOrder("BUGGER","BUGGER_COMBO","SIDE_MENU","BEVERAGE");
    }
}

