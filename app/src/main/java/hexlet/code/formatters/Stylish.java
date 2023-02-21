package hexlet.code.formatters;

import hexlet.code.Json;

import java.util.Map;
import java.util.Set;

public class Stylish {
    public static String formatStylish(Map<String, Object> map1, Map<String, Object> map2, int count) throws Exception {
        Set<String> allKeys = Json.getSortedKeys(map1, map2);
        String space = " ";
        final StringBuilder sb = new StringBuilder(space.repeat(count) + "{\n");
        for (String key : allKeys) {
            if (map1 == null) {
                sb.append(space.repeat(count)).append("  + ").append(key).append(": ").append(map2.get(key))
                        .append("\n");
            } else if (map2 == null) {
                sb.append(space.repeat(count)).append("  + ").append(key).append(": ").append(map1.get(key))
                        .append("\n");
            } else if (map1.containsKey(key) && !map2.containsKey(key)) {
                sb.append(space.repeat(count)).append("  - ").append(key).append(": ").append(map1.get(key))
                        .append("\n");
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                sb.append(space.repeat(count)).append("  + ").append(key).append(": ").append(map2.get(key))
                        .append("\n");
            } else {
                sb.append(stylishDiffer(count, key, map1, map2));
            }
        }
        sb.append(space.repeat(count)).append("}");
        return sb.toString();
    }
    private static String stylishDiffer(int count, String key, Map<String, Object> map1, Map<String, Object> map2) {
        String space = " ";
        Object object1 = map1.get(key);
        Object object2 = map2.get(key);
        StringBuilder sb = new StringBuilder();
        if (object1 == null || object2 == null ? object1 == object2 : map1.get(key).equals(map2.get(key))) {
            sb.append(space.repeat(count)).append("    ").append(key).append(": ").append(map1.get(key)).append("\n");
        } else {
            sb.append(space.repeat(count)).append("  - ").append(key).append(": ").append(map1.get(key)).append("\n");
            sb.append(space.repeat(count)).append("  + ").append(key).append(": ").append(map2.get(key)).append("\n");
        }
        return sb.toString();
    }
}
