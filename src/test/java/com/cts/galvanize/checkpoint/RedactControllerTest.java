package com.cts.galvanize.checkpoint;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RedactController.class)

public class RedactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRedactWitMultipleBadwords() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/redact")
                .param("original", "A little of this and a little of that")
                .param("badwords","little")
                .param("badwords","this");
        this.mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().string("A ****** of **** and a ****** of that"));
    }
}
