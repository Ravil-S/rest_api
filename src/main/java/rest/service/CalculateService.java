package rest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@NoArgsConstructor
public class CalculateService {

    public String getCharFreqJSON(String text) {

        if (text == null) return "{\"error\":\"no string\"}";
        if (text.equals("")) return "{\"error\":\"no string\"}";

        if (text.length()>100) return "{\"error\":\"string length > 100\"}";

            char[] chars = text.toCharArray();

            HashMap<Character, Long> hashMap = new LinkedHashMap<>();

            for (char ch : chars) {
                if (!hashMap.isEmpty()) {
                    if (hashMap.containsKey(ch)) {
                        hashMap.replace(ch, hashMap.get(ch) + 1);
                        continue;
                    }
                }
                hashMap.put(ch, 1L);
            }

            Map<Character, Long> sortedMap = hashMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


            ObjectMapper objectMapper = new ObjectMapper();
            String jacksonData = "{\"error\":\"no string\"}";
            try {
                jacksonData = objectMapper.writeValueAsString(sortedMap);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return jacksonData;

    }

}
