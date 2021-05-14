package com.cts.galvanize.checkpoint;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SedController.class)
public class SedControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSed() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/sed/little/lot")
                .content("a little of this and a little of that");
        this.mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().string("a lot of this and a lot of that"));
    }
}

