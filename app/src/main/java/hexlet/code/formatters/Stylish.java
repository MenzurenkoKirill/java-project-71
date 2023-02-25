package hexlet.code.formatters;

import hexlet.code.Differ;

import java.util.Map;
import java.util.Set;

public class Stylish {
    public static String formatStylish(Map<String, Object> firstMap, Map<String, Object> secondMap, int count)
            throws Exception {
        Set<String> allKeys = Differ.getAllSortedKeys(firstMap, secondMap);
        String space = " ";
        final StringBuilder sb = new StringBuilder(space.repeat(count) + "{\n");
        for (String key : allKeys) {
            if (firstMap == null) {
                sb.append(space.repeat(count))
                        .append("  + ")
                        .append(key)
                        .append(": ")
                        .append(secondMap.get(key))
                        .append("\n");
            } else if (secondMap == null) {
                sb.append(space.repeat(count)).append("  + ")
                        .append(key)
                        .append(": ")
                        .append(firstMap.get(key))
                        .append("\n");
            } else if (firstMap.containsKey(key) && !secondMap.containsKey(key)) {
                sb.append(space.repeat(count)).append("  - ")
                        .append(key)
                        .append(": ")
                        .append(firstMap.get(key))
                        .append("\n");
            } else if (!firstMap.containsKey(key) && secondMap.containsKey(key)) {
                sb.append(space.repeat(count))
                        .append("  + ").append(key)
                        .append(": ")
                        .append(secondMap.get(key))
                        .append("\n");
            } else {
                sb.append(stylishDiffer(count, key, firstMap, secondMap));
            }
        }
        sb.append(space.repeat(count)).append("}");
        return sb.toString();
    }
    private static String stylishDiffer(int countOfIndents, String key, Map<String, Object> firstMapForComparison,
                                        Map<String, Object> secondMapForComparison) {
        String space = " ";
        Object objectOfTheFirstComparedMap = firstMapForComparison.get(key);
        Object objectOfTheSecondComparedMap = secondMapForComparison.get(key);
        StringBuilder sb = new StringBuilder();
        if (objectOfTheFirstComparedMap == null || objectOfTheSecondComparedMap == null
                ? objectOfTheFirstComparedMap == objectOfTheSecondComparedMap
                : firstMapForComparison.get(key).equals(secondMapForComparison.get(key))) {
            sb.append(space.repeat(countOfIndents)).append("    ")
                    .append(key)
                    .append(": ")
                    .append(firstMapForComparison.get(key))
                    .append("\n");
        } else {
            sb.append(space.repeat(countOfIndents))
                    .append("  - ")
                    .append(key)
                    .append(": ")
                    .append(firstMapForComparison.get(key))
                    .append("\n");
            sb.append(space.repeat(countOfIndents))
                    .append("  + ")
                    .append(key)
                    .append(": ")
                    .append(secondMapForComparison.get(key))
                    .append("\n");
        }
        return sb.toString();
    }
}
