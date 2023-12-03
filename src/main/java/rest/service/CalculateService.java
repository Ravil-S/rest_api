package rest.service;

import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class CalculateService {

    public Map<String, Long> getCharFreqMap(String text) {
        if (StringUtils.isEmpty(text)) {
            return Collections.emptyMap();
        }
        if (text.length() > 10000) {
            throw new IllegalArgumentException("Max length of input string should be less 10k symbols");
        }

        //подсчет символов и запись в порядке их нахождения в строке,
        //для обеспечения предсказуемого порядка,
        // в случае если будут разные символы с одинаковым количестве вхождений
        Map<String, Long> map = new LinkedHashMap<>();
        for (char ch : text.toCharArray()) {
            Long count = map.get(String.valueOf(ch));
            if (count == null) {
                map.put(String.valueOf(ch), 1L);
            } else {
                map.put(String.valueOf(ch), count + 1);
            }
        }

        //сортировка по убыванию количества вхождений
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
