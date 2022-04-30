package com.example.gcbugger.controller.menu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class MenuRestControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    void 성공_전체_조회() throws Exception {
        //when
        ResultActions result = mockMvc.perform(
                get("/api/v1/menu")
                        .accept(MediaType.APPLICATION_JSON)
        );

        //then
        result.andExpect(status().isOk())
                .andExpect(handler().handlerType(MenuRestController.class))
                .andExpect(handler().methodName("findList"));

        result.andExpect(content().contentType("application/json;charset=utf-8"))
                .andExpect(content().encoding(StandardCharsets.UTF_8))
                .andExpect(content().string(
                        "[{\"id\":1,\"type\":\"BUGGER\",\"name\":\"불고기 버거\",\"price\":2300,\"kcal\":430}," +
                                "{\"id\":2,\"type\":\"BUGGER\",\"name\":\"빅맥\",\"price\":4600,\"kcal\":512}," +
                                "{\"id\":3,\"type\":\"BUGGER_COMBO\",\"name\":\"불고기 버거 세트\",\"price\":4300,\"kcal\":980}," +
                                "{\"id\":4,\"type\":\"BUGGER_COMBO\",\"name\":\"빅맥 세트\",\"price\":5900,\"kcal\":1105}," +
                                "{\"id\":5,\"type\":\"SIDE_MENU\",\"name\":\"후렌치 후라이 M\",\"price\":1700,\"kcal\":323}," +
                                "{\"id\":6,\"type\":\"SIDE_MENU\",\"name\":\"맥너겟 4조각\",\"price\":1800,\"kcal\":175}," +
                                "{\"id\":7,\"type\":\"BEVERAGE\",\"name\":\"코카 콜라\",\"price\":1300,\"kcal\":101}," +
                                "{\"id\":8,\"type\":\"BEVERAGE\",\"name\":\"코카 콜라 제로\",\"price\":1300,\"kcal\":0}]"
                ));
    }

    @Test
    void 성공_메뉴_타입으로_조회_음료() throws Exception {
        //when
        String menuType = "BEVERAGE";
        ResultActions result = mockMvc.perform(
                get("/api/v1/menu")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(String.format("{\"menuType\":\"%s\"}", menuType))
        );

        //then
        result.andExpect(status().isOk())
                .andExpect(handler().handlerType(MenuRestController.class))
                .andExpect(handler().methodName("findList"));

        result.andExpect(content().contentType("application/json;charset=utf-8"))
                .andExpect(content().encoding(StandardCharsets.UTF_8))
                .andExpect(content().string(
                        "[{\"id\":7,\"type\":\"BEVERAGE\",\"name\":\"코카 콜라\",\"price\":1300,\"kcal\":101}," +
                                "{\"id\":8,\"type\":\"BEVERAGE\",\"name\":\"코카 콜라 제로\",\"price\":1300,\"kcal\":0}]"
                ));
    }

    @Test
    void 성공_메뉴_아이디로_조회() throws Exception {
        //when
        Long id = 1L;
        ResultActions result = mockMvc.perform(
                get("/api/v1/menu" +"/" + id)
                        .accept(MediaType.APPLICATION_JSON)
        );

        //then
        result.andExpect(status().isOk())
                .andExpect(handler().handlerType(MenuRestController.class))
                .andExpect(handler().methodName("findById"));

        result.andExpect(content().contentType("application/json;charset=utf-8"))
                .andExpect(content().encoding(StandardCharsets.UTF_8))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.type").value("BUGGER"))
                .andExpect(jsonPath("$.name").value("불고기 버거"))
                .andExpect(jsonPath("$.price").value("2300"))
                .andExpect(jsonPath("$.kcal").value("430"));

    }
}