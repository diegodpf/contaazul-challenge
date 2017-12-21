package com.contaazul;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MarsIntegrationTest {
    private static final String BASE_URL = "/rest/mars/";

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.context)
                .build();
    }

    @Test
    public void moveRobotSuccessfullyTest() throws Exception {
        moveRobot("MMRMMRMM")
                .andExpect(content().string("(2, 0, S)"))
                .andExpect(status().isOk());

        moveRobot("MML")
                .andExpect(content().string("(0, 2, W)"))
                .andExpect(status().isOk());

        moveRobot("MML")
                .andExpect(content().string("(0, 2, W)"))
                .andExpect(status().isOk());
    }

    @Test
    public void moveRobotUnsuccessfullyTest() throws Exception {
        moveRobot("AAA")
                .andExpect(content().string("400 Bad Request"))
                .andExpect(status().isBadRequest());

        moveRobot("MMMMMMMMMMMMMMMMMMMMMMMM")
                .andExpect(content().string("400 Bad Request"))
                .andExpect(status().isBadRequest());
    }

    private ResultActions moveRobot(String commands) throws Exception {
        return mockMvc.perform(post(BASE_URL + commands));
    }
}
