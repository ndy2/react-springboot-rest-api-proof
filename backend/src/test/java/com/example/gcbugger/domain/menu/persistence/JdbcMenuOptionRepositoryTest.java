package com.example.gcbugger.domain.menu.persistence;

import com.example.gcbugger.domain.menu.domain.entity.MenuOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
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
        List<MenuOption> foundMenuOptions = menuOptionRepository.findByMenuTypeId(2L);

        //then
        assertThat(foundMenuOptions).hasSize(2);
        assertThat(foundMenuOptions.get(0).getMenuType().getName()).isEqualTo("BUGGER_COMBO");
        assertThat(foundMenuOptions.get(0).getMenuType().getId()).isEqualTo(2);
        assertThat(foundMenuOptions).extracting("name")
                .containsExactlyInAnyOrder("제로 콜라로 바꿔줘", "감튀를 맥너겟으로 빠꿔줘");
        assertThat(foundMenuOptions).extracting("price")
                .containsExactlyInAnyOrder(0, 600);
    }
}