package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static hexlet.code.Differ.differ;
import static hexlet.code.Differ.getAllSortedKeys;

public class Json {
    public static String formatJson(Map<String, Object> firstMap, Map<String, Object> secondMap) throws Exception {
        Set<String> allKeys = getAllSortedKeys(firstMap, secondMap);
        Map<String, Object> result = new LinkedHashMap<>();
        for (String key : allKeys) {
            if (firstMap.containsKey(key) && !secondMap.containsKey(key)) {
                result.put("- " + key, firstMap.get(key));
            } else if (!firstMap.containsKey(key) && secondMap.containsKey(key)) {
                result.put("+ " + key, secondMap.get(key));
            } else if (differ(firstMap, secondMap, key)) {
                result.put("- " + key, firstMap.get(key));
                result.put("+ " + key, secondMap.get(key));
            } else {
                result.put("  " + key, secondMap.get(key));
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(result);
    }
}
