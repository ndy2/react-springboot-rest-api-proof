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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
        result.andDo(print());
        result.andExpect(status().isOk())
                .andExpect(handler().handlerType(MenuRestController.class))
                .andExpect(handler().methodName("findAll"));

        result.andExpect(content().contentType("application/json;charset=utf-8"))
                .andExpect(content().encoding(StandardCharsets.UTF_8));
    }

    @Test
    void 성공_메뉴_타입으로_조회_음료() throws Exception {
        //when
        String menuType = "BEVERAGE";
        ResultActions result = mockMvc.perform(
                get("/api/v1/menu")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        );

        //then
        result.andDo(print());
        result.andExpect(status().isOk())
                .andExpect(handler().handlerType(MenuRestController.class))
                .andExpect(handler().methodName("findAll"));

        result.andExpect(content().contentType("application/json;charset=utf-8"))
                .andExpect(content().encoding(StandardCharsets.UTF_8));
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
                .andExpect(content().encoding(StandardCharsets.UTF_8));

    }
}