package com.example.gcbugger.domain.menu.persistence;

import com.example.gcbugger.domain.menu.domain.entity.MenuType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
@TestPropertySource("classpath:application-test.properties")
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

