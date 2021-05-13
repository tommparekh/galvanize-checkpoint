package com.cts.galvanize.checkpoint;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CamelizeController.class)
public class CamelizeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCamelizeWithoutInitialCap() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/camelize")
                .param("original", "this_is_a_thing");
        this.mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().string("thisIsAThing"));
    }

    @Test
    public void testCamelizeWithInitialCapAsFalse() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/camelize")
                .param("original", "this_is_a_thing")
                .param("initialCap", "false");
        this.mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().string("thisIsAThing"));
    }

    @Test
    public void testCamelizeWithInitialCapAsTrue() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/camelize")
                .param("original", "this_is_a_thing")
                .param("initialCap", "true");
        this.mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().string("ThisIsAThing"));
    }



}
