package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Json;

import java.io.File;
import java.nio.file.Path;
import java.util.Map;

import static java.nio.file.Files.readString;

public class Parser {
    public static String generate(String firstFileName, String secondFileName, String formatName) throws Exception {
        Map<String, Object> firstFileMap = convertFileToMap(firstFileName);
        Map<String, Object> secondFileMap = convertFileToMap(secondFileName);
        int count = 0;
        return switch (formatName) {
            case "stylish" -> Stylish.formatStylish(firstFileMap, secondFileMap, count);
            case "json" -> Json.formatJson(firstFileMap, secondFileMap);
            case "plain" -> Plain.formatPlain(firstFileMap, secondFileMap);
            default -> "Output format error, check method argument";
        };
    }
    public static String generate(String firstFileName, String secondFileName) throws Exception {
        return generate(firstFileName, secondFileName, "stylish");
    }
    public static Map<String, Object> convertFileToMap(String filePath) throws Exception {
        Path fullFilePath = getToFullPath(filePath);
        Map<String, Object> file = null;
        if (filePath.endsWith(".json")) {
            file = convertJsonToMap(fullFilePath);
        } else if (filePath.endsWith(".yml")) {
            file = convertYamlToMap(fullFilePath);
        }
        return  file;
    }
    private static Map<String, Object> convertYamlToMap(Path fullFilePath) throws Exception {
        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(readString(fullFilePath), new TypeReference<>() { });
    }
    private static Map<String, Object> convertJsonToMap(Path fullFilePath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(readString(fullFilePath), new TypeReference<Map<String, Object>>() { });
    }
    private static Path getToFullPath(String filePath) throws Exception {
        String defaultPath = "src/main/resources";
        File file = new File(defaultPath);
        String absolutePathForFile = file.getAbsolutePath();
        Path resultPath = Path.of(filePath);
        if (!filePath.startsWith("/")) {
            resultPath = Path.of(absolutePathForFile + "/" + filePath);
        }
        if (new File(resultPath.toString()).exists()) {
            return resultPath;
        }
        throw new RuntimeException("Файл: " + resultPath + " не существует");
    }
}
