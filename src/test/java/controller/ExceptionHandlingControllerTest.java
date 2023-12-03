package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import rest.controller.ExceptionHandlingController;
import rest.controller.RestAPIController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ExceptionHandlingControllerTest {

    private MockMvc mockMvc;

    @Mock
    RestAPIController restAPIController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(restAPIController)
                .setControllerAdvice(new ExceptionHandlingController())
                .build();
    }


    @Test
    public void exception() throws Exception {
        Mockito.when(restAPIController.calcCharFreqMap(null))
                .thenThrow(new RuntimeException("Unexpected Exception"));
        mockMvc.perform(get("/")).andExpect(status().is(500));
    }
}



