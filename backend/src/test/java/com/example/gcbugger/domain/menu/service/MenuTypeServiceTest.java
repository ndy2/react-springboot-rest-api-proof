package com.example.gcbugger.domain.menu.service;

import com.example.gcbugger.domain.menu.domain.entity.MenuType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MenuTypeServiceTest {

    @Autowired MenuTypeService menuTypeService;

    @Test
    void 성공_전체_조회(){
        //given
        //initial data (see schema.sql)

        //when
        List<MenuType> menuTypes = menuTypeService.findAll();

        //then
        assertThat(menuTypes).hasSize(4);
        assertThat(menuTypes).extracting("name")
                .containsExactlyInAnyOrder("BUGGER","BUGGER_COMBO","SIDE_MENU","BEVERAGE");
    }
}