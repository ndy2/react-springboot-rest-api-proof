package com.example.gcbugger.domain.menu.persistence;

import com.example.gcbugger.domain.menu.domain.MenuType;
import com.example.gcbugger.domain.menu.domain.entity.Menu;
import com.example.gcbugger.domain.testutil.JdbcTestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@Transactional
@SpringJUnitConfig
@ContextConfiguration(classes = JdbcTestConfig.class)
class JdbcMenuRepositoryTest{

    @Autowired NamedParameterJdbcTemplate jdbcTemplate;
    JdbcMenuRepository menuRepository;

    @BeforeEach
    void setUp() {
        menuRepository = new JdbcMenuRepository(jdbcTemplate);
    }

    @Test
    void 성공_전체_조회() {
        //given
        //initial data (see schema.sql)

        //when
        List<Menu> foundMenus = menuRepository.findAll();

        //then
        assertThat(foundMenus).extracting("name")
                .containsExactlyInAnyOrder("불고기 버거", "빅맥", "불고기 버거 세트", "빅맥 세트", "후렌치 후라이 M", "맥너겟 4조각", "코카 콜라", "코카 콜라 제로");
        assertThat(foundMenus).extracting("price")
                .containsExactlyInAnyOrder(2300, 4600, 4300, 5900, 1700, 1800, 1300, 1300);
        assertThat(foundMenus).extracting("kcal")
                .containsExactlyInAnyOrder(430, 512, 980, 1105, 323, 175, 101, 0);

    }

    @Test
    void 성공_메뉴_타입으로_조회() {
        //given
        //initial data (see schema.sql)

        //when
        List<Menu> foundMenus = menuRepository.findByType(MenuType.BUGGER);

        //then
        assertThat(foundMenus).extracting("name")
                .containsExactlyInAnyOrder("불고기 버거", "빅맥");
        assertThat(foundMenus).extracting("price")
                .containsExactlyInAnyOrder(2300, 4600);
        assertThat(foundMenus).extracting("kcal")
                .containsExactlyInAnyOrder(430, 512);
    }

    @Test
    void 성공_메뉴_타입과_이름으로_조회() {
        //given
        //initial data (see schema.sql)

        //when
        Optional<Menu> foundMenu = menuRepository.findByTypeAndName(MenuType.BUGGER, "빅맥");

        //then
        assertThat(foundMenu).isPresent();
        assertThat(foundMenu.get().getName()).isEqualTo("빅맥");
        assertThat(foundMenu.get().getPrice()).isEqualTo(4600);
        assertThat(foundMenu.get().getKcal()).isEqualTo(512);
    }
}