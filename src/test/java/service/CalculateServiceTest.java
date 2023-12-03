package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rest.service.CalculateService;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CalculateServiceTest {

    private CalculateService calculateService = new CalculateService();

    @Test
    void getCharFreqMap(){
        String input = "aazzzfff";
        Map<String, Long> output = new HashMap<>();
        output.put("a", 2L);
        output.put("z", 3L);
        output.put("f", 3L);

        Map<String, Long> map = calculateService.getCharFreqMap(input);
        Assertions.assertEquals(output, map);
    }

    @Test
    void inputNull(){
        String input = null;
        Map<String, Long> output = Collections.emptyMap();

        Map<String, Long> map = calculateService.getCharFreqMap(input);
        Assertions.assertEquals(output, map);
    }

    @Test
    void inputVoid(){
        String input = "";
        Map<String, Long> output = Collections.emptyMap();

        Map<String, Long> map = calculateService.getCharFreqMap(input);
        Assertions.assertEquals(output, map);
    }

    @Test
    void lengthOverMax(){

        String input = "a".repeat(10_001);

        Assertions.assertThrows(IllegalArgumentException.class, ()->calculateService.getCharFreqMap(input));
    }
}
