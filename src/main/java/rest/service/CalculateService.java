package rest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class CalculateService {

    public Map<String, Long> getCharFreqMap(String text) {

        if (text == null) return null;
        if (text.equals("")) return null;
        if (text.length()>100) return null;

        char[] chars = text.toCharArray();

        HashMap<String, Long> hashMap = new LinkedHashMap<>();

        for (char ch : chars) {
            if (!hashMap.isEmpty()) {
                if (hashMap.containsKey(String.valueOf(ch))) {
                    hashMap.replace(String.valueOf(ch), hashMap.get(String.valueOf(ch)) + 1);
                    continue;
                }
            }
            hashMap.put(String.valueOf(ch), 1L);
        }

        Map<String, Long> sortedMap = hashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return sortedMap;
    }
}
