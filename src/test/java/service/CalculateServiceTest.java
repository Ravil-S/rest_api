package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rest.service.CalculateService;

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
        String output = "{\"error\":\"no string\"}";

        String json = calculateService.getCharFreqJSON(input);
        Assertions.assertEquals(output, json);
    }

    @Test
    void inputVoid(){
        String input = "";
        String output = "{\"error\":\"no string\"}";

        String json = calculateService.getCharFreqJSON(input);
        Assertions.assertEquals(output, json);
    }

    @Test
    void lenghtOver100(){

        String input = "a".repeat(101);
        String output = "{\"error\":\"string length > 100\"}";

        String json = calculateService.getCharFreqJSON(input);
        Assertions.assertEquals(output, json);
    }
}
