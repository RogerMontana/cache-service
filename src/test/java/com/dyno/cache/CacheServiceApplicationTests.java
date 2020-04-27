package com.dyno.cache;

import com.dyno.cache.api.CacheController;
import com.dyno.cache.service.RequestService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CacheController.class)
public class CacheServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RequestService requestService;

    @Test
    @DisplayName("Should return valid value from get")
    public void greetingShouldReturnDefaultMessage() throws Exception {

        when(requestService.getIteration("hello")).thenReturn("1hello");

        this.mockMvc.perform(get("http://localhost:8080/iterate/hello"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("1hello")));
    }

}
