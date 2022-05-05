package com.example.gcbugger.domain.menu.domain.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static com.example.gcbugger.domain.fixture.Fixture.buggerType;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MenuTest {

    @Test
    void 성공_생성() {
        //when
        Menu menu = Menu.create(buggerType(), "불고기 버거", 2300, 430, "image.png");

        //then
        assertThat(menu).isNotNull();
        assertThat(menu.getId()).isNull();
        assertThat(menu.getType().getId()).isEqualTo(buggerType().getId());
        assertThat(menu.getType().getName()).isEqualTo(buggerType().getName());
        assertThat(menu.getName()).isEqualTo("불고기 버거");
        assertThat(menu.getPrice()).isEqualTo(2300);
        assertThat(menu.getKcal()).isEqualTo(430);
        assertThat(menu.getImageFileName()).isEqualTo("image.png");
    }

    @Test
    void 실패_널_메뉴타입() {
        //given
        MenuType menuType = null;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Menu.create(menuType, "불고기 버거", 2300, 430, "image.png"));
    }

    @NullAndEmptySource
    @ParameterizedTest
    void 실패_생성_빈_이름(String name) {
        //given
        //null and empty name

        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Menu.create(buggerType(), name, 2300, 430, "image.png"));
    }

    @Test
    void 실패_생성_50자가넘는_이름() {
        //given
        String name = "0123456789" + "0123456789" + "0123456789" + "0123456789" + "0123456789" + "0";

        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Menu.create(buggerType(), name, 2300, 430, "image.png"));
    }

    @Test
    void 실패_생성_음수_가격() {
        //given
        int price = -1;

        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Menu.create(buggerType(), "불고기 버거", price, 430, "image.png"));
    }

    @Test
    void 실패_생성_음수_칼로리() {
        //given
        int kcal = -1;

        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Menu.create(buggerType(), "불고기 버거", 2300, kcal, "image.png"));
    }
}