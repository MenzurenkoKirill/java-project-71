package hexlet.code.formatters;

import hexlet.code.Differ;

import java.util.Map;
import java.util.Set;

public class Plain {
    public static String formatPlain(Map<String, Object> firstMap, Map<String, Object> secondMap) throws Exception {
        Set<String> allKeys = Differ.getAllSortedKeys(firstMap, secondMap);
        final StringBuilder sb = new StringBuilder();
        for (String key : allKeys) {
            if (firstMap.containsKey(key) && !secondMap.containsKey(key)) {
                sb.append("Property '")
                        .append(key)
                        .append("' was removed")
                        .append("\n");
            } else if (!firstMap.containsKey(key) && secondMap.containsKey(key)) {
                sb.append("Property '")
                        .append(key)
                        .append("' was added with value: ")
                        .append(getValue(secondMap, key))
                        .append("\n");
            } else if (Differ.differ(firstMap, secondMap, key)) {
                sb.append("Property '")
                        .append(key)
                        .append("' was updated. From ")
                        .append(getValue(firstMap, key))
                        .append(" to ")
                        .append(getValue(secondMap, key))
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
