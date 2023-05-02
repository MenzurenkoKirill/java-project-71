package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

import static hexlet.code.DataSupplier.getContentFromFile;
import static hexlet.code.DiffBuilder.getDiff;


public class Differ {
    public static String generate(String firstPath, String secondPath, String formatName)
            throws Exception {
        Map<String, Object> data1 = getContentFromFile(firstPath);
        Map<String, Object> data2 = getContentFromFile(secondPath);
        List<Link> difference = getDiff(data1, data2);
        return selectFormat(difference, formatName);
    }
    public static String generate(String firstFileName, String secondFileName) throws Exception {
        return generate(firstFileName, secondFileName, "stylish");
    }
    private static String selectFormat(List<Link> mapsDifference, String formatName) throws Exception {
        return switch (formatName) {
            case "stylish" -> Stylish.format(mapsDifference);
            case "json" -> Json.format(mapsDifference);
            case "plain" -> Plain.format(mapsDifference);
            default -> throw new RuntimeException("Output format error, format - \"" + formatName + "\" "
                    + "is not processed!");
        };
    }
}
