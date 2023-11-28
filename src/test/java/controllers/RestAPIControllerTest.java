package controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import rest.controllers.RestAPIController;
import rest.service.CalculateService;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class RestAPIControllerTest {

    @Mock
    private CalculateService calculateService = new CalculateService();

    @InjectMocks
    private RestAPIController restAPIController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
       mockMvc = MockMvcBuilders.standaloneSetup(restAPIController).build();
    }

    @Test
    void calcCharFreq() throws Exception {
        String input = "text";
        when(calculateService.getCharFreqJSON(input)).thenReturn("ok");
        mockMvc.perform(post("/")
                .contentType(MediaType.TEXT_PLAIN)
                .content(input))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("ok"));
    }
}
