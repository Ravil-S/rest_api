package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rest.service.CalculateService;

import java.util.HashMap;
import java.util.Map;

public class CalculateServiceTest {

    private CalculateService calculateService = new CalculateService();

    @Test
    void getCharFreqMap(){
        String input = "fffffzzz";
        Map<String, Long> output = new HashMap<>();
        output.put("f", 5L);
        output.put("z", 3L);

        Map<String, Long> map = calculateService.getCharFreqMap(input);
        Assertions.assertEquals(output, map);
    }

    @Test
    void inputNullMap(){
        String input = null;
        Map<String, Long> output = null;

        Map<String, Long> map = calculateService.getCharFreqMap(input);
        Assertions.assertEquals(output, map);
    }

    @Test
    void inputVoidMap(){
        String input = "";
        Map<String, Long> output = null;

        Map<String, Long> map = calculateService.getCharFreqMap(input);
        Assertions.assertEquals(output, map);
    }

    @Test
    void lenghtOver100Map(){

        String input = "a".repeat(101);
        Map<String, Long> output = null;

        Map<String, Long> map = calculateService.getCharFreqMap(input);
        Assertions.assertEquals(output, map);
    }


}
