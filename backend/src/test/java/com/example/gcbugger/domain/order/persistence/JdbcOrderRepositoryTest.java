package com.example.gcbugger.domain.order.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
class JdbcOrderRepositoryTest {

    @Autowired NamedParameterJdbcTemplate jdbcTemplate;
    JdbcOrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository = new JdbcOrderRepository(jdbcTemplate);
    }

    @Test
    void 성공_삽입(){

    }
}