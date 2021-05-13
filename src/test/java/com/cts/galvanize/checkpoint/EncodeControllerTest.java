package com.cts.galvanize.checkpoint;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EncodeController.class)
public class EncodeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testEncode() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/encode")
                .param("message", "a little of this and a little of that")
                .param("key","mcxrstunopqabyzdefghijklvw");
        this.mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().string("m aohhas zt hnog myr m aohhas zt hnmh"));
    }
}
