package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Json {
    public static String jsonFormat(Map<String, Object> map1, Map<String, Object> map2) throws Exception {
        Set<String> allKeys = getSortedKeys(map1, map2);
        Map<String, Object> result = new LinkedHashMap<>();
        for (String key : allKeys) {
            if (map1.containsKey(key) && !map2.containsKey(key)) {
                result.put("- " + key, map1.get(key));
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                result.put("+ " + key, map2.get(key));
            } else if (differ(map1, map2, key)) {
                result.put("- " + key, map1.get(key));
                result.put("+ " + key, map2.get(key));
            } else {
                result.put("  " + key, map2.get(key));
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(result);
    }
    public static boolean differ(Map<String, Object> file1, Map<String, Object> file2, String key) throws Exception {
        Object obj1 = file1.get(key);
        Object obj2 = file2.get(key);
        return (obj1 == null || obj2 == null ? obj1 != obj2 : !obj1.equals(obj2));
    }
    public static Set<String> getSortedKeys(Map<String, Object> map1, Map<String, Object> map2) throws Exception {
        Set<String> keys1 = keysFromMap(map1);
        Set<String> keys2 = keysFromMap(map2);
        keys1.addAll(keys2);
        return keys1.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
    }
    public static Set<String> keysFromMap(Map<String, Object> map) {
        Set<String> result = new HashSet<>();
        if (map == null) {
            return result;
        }
        for (Map.Entry<String, Object> keys : map.entrySet()) {
            result.add(keys.getKey());
        }
        return result;
    }
}
