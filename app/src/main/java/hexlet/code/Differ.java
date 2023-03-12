package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;


import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static hexlet.code.Parser.convertFileToMap;
import static hexlet.code.Distinctions.differenceList;

public class Differ {
    public static String generate(String firstFileNameForConvert, String secondFileNameForConvert, String formatName)
            throws Exception {
        Map<String, Object> firstFileMapForGenerate = convertFileToMap(firstFileNameForConvert);
        Map<String, Object> secondFileMapForGenerate = convertFileToMap(secondFileNameForConvert);
        List<Link> mapsDifference = differenceList(firstFileMapForGenerate, secondFileMapForGenerate);
        return formatSelectionForConvert(mapsDifference, formatName);
    }
    public static String generate(String firstFileName, String secondFileName) throws Exception {
        return generate(firstFileName, secondFileName, "stylish");
    }
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
    private static String formatSelectionForConvert(List<Link> mapsDifference, String formatName) throws Exception {
        return switch (formatName) {
            case "stylish" -> Stylish.formatStylish(mapsDifference);
            case "json" -> Json.formatJson(mapsDifference);
            case "plain" -> Plain.formatPlain(mapsDifference);
            default -> "Output format error, check method argument";
        };
    }
}
