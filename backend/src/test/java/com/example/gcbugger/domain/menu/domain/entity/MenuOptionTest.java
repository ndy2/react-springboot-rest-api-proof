package com.example.gcbugger.domain.menu.domain.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static com.example.gcbugger.domain.testutil.Fixture.buggerType;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MenuOptionTest {

    @Test
    void 성공_생성() {
        //when
        MenuOption menuOption = new MenuOption(1L, buggerType(), "피클을 빼줘", 0);

        //then
        assertThat(menuOption).isNotNull();
        assertThat(menuOption.getId()).isEqualTo(1L);
        assertThat(menuOption.getMenuType().getId()).isEqualTo(buggerType().getId());
        assertThat(menuOption.getMenuType().getName()).isEqualTo(buggerType().getName());
        assertThat(menuOption.getName()).isEqualTo("피클을 빼줘");
        assertThat(menuOption.getPrice()).isEqualTo(0);
    }

    @Test
    void 실패_널_메뉴타입() {
        //given
        MenuType menuType = null;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new MenuOption(1L, menuType, "피클을 빼줘", 0));
    }

    @NullAndEmptySource
    @ParameterizedTest
    void 실패_생성_빈_이름(String name) {
        //given
        //null and empty name

        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new MenuOption(1L, buggerType(), name, 0));
    }

    @Test
    void 실패_생성_50자가넘는_이름() {
        //given
        String name = "0123456789" + "0123456789" + "0123456789" + "0123456789" + "0123456789" + "0";

        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new MenuOption(1L, buggerType(), name, 0));
    }

    @Test
    void 실패_생성_음수_가격() {
        //given
        int price = -1;

        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new MenuOption(1L, buggerType(), "피클을 빼줘", price));
    }
}