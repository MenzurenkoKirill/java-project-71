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

import static hexlet.code.Parser.retrieveData;
import static hexlet.code.DiffBuilder.getDiff;

public class Differ {
    public static String generate(String firstPath, String secondPath, String formatName)
            throws Exception {
        Map<String, Object> data1 = retrieveData(firstPath);
        Map<String, Object> data2 = retrieveData(secondPath);
        List<Link> difference = getDiff(data1, data2);
        return selectFormat(difference, formatName);
    }
    public static String generate(String firstFileName, String secondFileName) throws Exception {
        return generate(firstFileName, secondFileName, "stylish");
    }
    private static String selectFormat(List<Link> mapsDifference, String formatName) throws Exception {
        return switch (formatName) {
            case "stylish" -> Stylish.formatStylish(mapsDifference);
            case "json" -> Json.formatJson(mapsDifference);
            case "plain" -> Plain.formatPlain(mapsDifference);
            default -> throw new RuntimeException("Output format error, check method argument");
        };
    }
}
