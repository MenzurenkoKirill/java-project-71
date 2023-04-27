package code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import static hexlet.code.Parser.retrieveData;
import static hexlet.code.DiffBuilder.getDiff;
import static hexlet.code.Utils.getToFullPath;
import static java.nio.file.Files.readString;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;


public class Differ {
    public static String generate(String firstPath, String secondPath, String formatName)
            throws Exception {
        Map<String, Object> data1 = retrieveData(Utils.getToFullPath(firstPath));
        Map<String, Object> data2 = retrieveData(Utils.getToFullPath(secondPath));
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
            default -> throw new RuntimeException("Output format error, check method argument");
        };
    }
    public static Map<String, Object> convertYamlToMap(Path fullFilePath) throws Exception {
        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(readString(fullFilePath), new TypeReference<>() { });
    }
    public static Map<String, Object> convertJsonToMap(Path fullFilePath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(readString(fullFilePath), new TypeReference<Map<String, Object>>() { });
    }
}
