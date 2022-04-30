package com.example.gcbugger.domain.menu.service;

import com.example.gcbugger.domain.menu.domain.entity.Menu;
import com.example.gcbugger.domain.menu.domain.MenuRepository;
import com.example.gcbugger.domain.menu.domain.entity.MenuType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static com.example.gcbugger.domain.testutil.Fixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.Mockito.*;

class MenuServiceTest {

    MenuRepository menuRepository;
    MenuService menuService;

    @BeforeEach
    void setUp() {
        menuRepository = mock(MenuRepository.class);
        menuService = new MenuService(menuRepository);
    }

    @Test
    void 성공_전체_조회() {
        //given
        List<Menu> menus = List.of(buggerCombo(), bugger(), sideMenu(), beverage());
        when(menuRepository.findAll()).thenReturn(menus);

        //when
        List<Menu> foundMenus = menuService.findAll();

        //then
        verify(menuRepository).findAll();
        assertThat(foundMenus).hasSameElementsAs(menus);
    }

    @Test
    void 성공_메뉴_타입으로_조회(){
        //given
        List<Menu> menus = List.of(bugger(), bugger(), sideMenu(), beverage());
        MenuType type = buggerType();
        when(menuRepository.findByType(type)).thenReturn(menus);

        //when
        List<Menu> foundMenus = menuService.findByType(type);

        //then
        verify(menuRepository).findByType(type);
        assertThat(foundMenus).hasSameElementsAs(menus);
    }

    @Test
    void 성공_아이디로_조회(){
        //given
        Menu menu = beverage();
        when(menuRepository.findById(1L)).thenReturn(Optional.of(menu));

        //when
        Menu foundMenu = menuService.findById(1L);

        //then
        verify(menuRepository).findById(1L);
        assertThat(foundMenu).isEqualTo(menu);
    }

    @Test
    void 실패_메뉴_아이디_조회_널을_전달받는경우(){
        //given
        Menu menu = null;
        when(menuRepository.findById(1L)).thenReturn(Optional.ofNullable(menu));

        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> menuService.findById(1L));
        verify(menuRepository).findById(1L);
    }
}