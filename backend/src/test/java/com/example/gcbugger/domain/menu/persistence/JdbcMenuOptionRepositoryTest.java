package com.example.gcbugger.domain.menu.persistence;

import com.example.gcbugger.domain.menu.domain.MenuType;
import com.example.gcbugger.domain.menu.domain.entity.MenuOption;
import com.example.gcbugger.domain.testutil.JdbcTestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@Transactional
@SpringJUnitConfig
@ContextConfiguration(classes = JdbcTestConfig.class)
class JdbcMenuOptionRepositoryTest {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    JdbcMenuOptionRepository menuOptionRepository;

    @BeforeEach
    void setUp() {
        menuOptionRepository = new JdbcMenuOptionRepository(jdbcTemplate);
    }

    @Test
    void 성공_메뉴_타입으로_조회() {
        //given
        //initial data (see schema.sql)

        //when
        List<MenuOption> foundMenuOptions = menuOptionRepository.findByMenuType(MenuType.BUGGER_COMBO);

        //then
        assertThat(foundMenuOptions).extracting("name")
                .containsExactlyInAnyOrder("제로 콜라로 바꿔줘", "감튀를 맥너겟으로 빠꿔줘");
        assertThat(foundMenuOptions).extracting("price")
                .containsExactlyInAnyOrder(0, 600);
    }
}