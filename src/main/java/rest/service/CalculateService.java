package rest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@NoArgsConstructor
public class CalculateService {

    public String getCharFreqJSON(String text){

        char[] chars = text.toCharArray();
        System.out.println(chars.length);

        HashMap<Character, Long> hashMap = new HashMap<>();

        for (char ch: chars) {
            if (!hashMap.isEmpty()){
                if (hashMap.containsKey(ch)){
                    hashMap.replace(ch, hashMap.get(ch)+1);
                    continue;
                }
            }
            hashMap.put(ch, 1L);
        }

        Map<Character, Long>  sortedMap =  hashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


        ObjectMapper objectMapper = new ObjectMapper();
        String jacksonData = null;
        try {
            jacksonData = objectMapper.writeValueAsString(sortedMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jacksonData;
    }

}
