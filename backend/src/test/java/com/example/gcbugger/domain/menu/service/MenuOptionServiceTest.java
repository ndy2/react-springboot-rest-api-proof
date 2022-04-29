package com.example.gcbugger.domain.menu.service;

import com.example.gcbugger.domain.menu.domain.MenuOptionRepository;
import com.example.gcbugger.domain.menu.domain.MenuType;
import com.example.gcbugger.domain.menu.domain.entity.Menu;
import com.example.gcbugger.domain.menu.domain.entity.MenuOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.gcbugger.domain.menu.domain.MenuType.BUGGER;
import static com.example.gcbugger.domain.testutil.Fixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class MenuOptionServiceTest {

    MenuOptionService menuOptionService;
    MenuOptionRepository menuOptionRepository;

    @BeforeEach
    void setUp() {
        menuOptionRepository = mock(MenuOptionRepository.class);
        menuOptionService = new MenuOptionService(menuOptionRepository);
    }

    @Test
    void 성공_메뉴_타입으로_조회(){
        //given
        MenuOption buggerOption = buggerOption();
        List<MenuOption> menuOptions = List.of(buggerOption, buggerComboOption());
        when(menuOptionRepository.findByMenuType(BUGGER)).thenReturn(menuOptions);

        //when
        List<MenuOption> foundMenuOptions = menuOptionService.findByType(BUGGER);

        //then
        verify(menuOptionRepository).findByMenuType(BUGGER);
        assertThat(foundMenuOptions).hasSameElementsAs(menuOptions);
    }
}