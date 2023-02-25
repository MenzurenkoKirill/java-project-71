package hexlet.code;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Differ {
    public static boolean differ(Map<String, Object> firstMapForComparison, Map<String, Object> secondMapForComparison,
                                 String comparisonKey) throws Exception {
        Object objectOfTheFirstComparedMap = firstMapForComparison.get(comparisonKey);
        Object objectOfTheSecondComparedMap = secondMapForComparison.get(comparisonKey);
        return (objectOfTheFirstComparedMap == null || objectOfTheSecondComparedMap == null
                ? objectOfTheFirstComparedMap != objectOfTheSecondComparedMap : !objectOfTheFirstComparedMap.
                equals(objectOfTheSecondComparedMap));
    }
    public static Set<String> getAllSortedKeys(Map<String, Object> firstMapWithNecessaryKeys,
                                               Map<String, Object> secondMapWithNecessaryKeys) throws Exception {
        Set<String> allKeysFromFirstMap = getAllKeysFromMap(firstMapWithNecessaryKeys);
        Set<String> allKeysFromSecondMap = getAllKeysFromMap(secondMapWithNecessaryKeys);
        allKeysFromFirstMap.addAll(allKeysFromSecondMap);
        return allKeysFromFirstMap.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
    public static Set<String> getAllKeysFromMap(Map<String, Object> map) {
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
