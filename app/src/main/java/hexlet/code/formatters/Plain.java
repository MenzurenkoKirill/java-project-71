package hexlet.code.formatters;

import hexlet.code.Json;

import java.util.Map;
import java.util.Set;

public class Plain {
    public static String formatStylish(Map<String, Object> map1, Map<String, Object> map2) throws Exception {
        Set<String> allKeys = Json.getSortedKeys(map1, map2);
        final StringBuilder sb = new StringBuilder();
        for (String key : allKeys) {
            if (map1.containsKey(key) && !map2.containsKey(key)) {
                sb.append("Property '").append(key).append("' was removed").append("\n");
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                sb.append("Property '").append(key).append("' was added with value: ").append(getValue(map2, key))
                        .append("\n");
            } else if (Json.differ(map1, map2, key)) {
                sb.append("Property '")
                        .append(key)
                        .append("' was updated. From ")
                        .append(getValue(map1, key))
                        .append(" to ")
                        .append(getValue(map2, key))
                        .append("\n");
            }
        }
        return sb.toString().trim();
    }
    private static String getValue(Map<String, Object> map, String key) {
        String result;
        if (map.get(key) == null) {
            result = null;
        } else if (map.get(key) instanceof String) {
            result = "'" + map.get(key) + "'";
        } else if (map.get(key) instanceof Integer) {
            result = map.get(key).toString();
        } else if (map.get(key) instanceof Boolean) {
            result = map.get(key).toString();
        } else {
            result = "[complex value]";
        }
        return result;
    }
}
