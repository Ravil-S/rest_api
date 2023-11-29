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
    void getCharFreqJSON(){
        String input = "aaabbcddddfff###111%%%   66";
        String output = "{\"d\":4,\"a\":3,\"f\":3,\"#\":3,\"1\":" +
                "3,\"%\":3,\" \":3,\"b\":2,\"6\":2,\"c\":1}";

        String json = calculateService.getCharFreqJSON(input);
        Assertions.assertEquals(output, json);
    }

    @Test
    void inputNull(){
        String input = null;
        String output = null;

        String json = calculateService.getCharFreqJSON(input);
        Assertions.assertEquals(output, json);
    }

    @Test
    void inputVoid(){
        String input = "";
        String output = null;

        String json = calculateService.getCharFreqJSON(input);
        Assertions.assertEquals(output, json);
    }

    @Test
    void lenghtOver100(){

        String input = "a".repeat(101);
        String output = null;

        String json = calculateService.getCharFreqJSON(input);
        Assertions.assertEquals(output, json);
    }

    //////// map ///////

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
