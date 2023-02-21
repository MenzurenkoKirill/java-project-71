package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import hexlet.code.formatters.Stylish;

import java.io.File;
import java.nio.file.Path;
import java.util.Map;

import static java.nio.file.Files.readString;

public class Parser {
    public static String generate(String path1, String path2, String format) throws Exception {
        Map<String, Object> map1 = fileToMap(path1);
        Map<String, Object> map2 = fileToMap(path2);
        int count = 0;
        return switch (format) {
            case "stylish" -> Stylish.formatStylish(map1, map2, count);
            case  "json" -> Json.jsonFormat(map1, map2);
            default -> "Output format error, check method argument";
        };
    }
    public static String generate(String path1, String path2) throws Exception {
        return generate(path1, path2, "stylish");
    }
    public static Map<String, Object> fileToMap(String filePath) throws Exception {
        Path fullPath = pathToFullPath(filePath);
        Map<String, Object> file = null;
        if (filePath.endsWith(".json")) {
            file = jsonToMap(fullPath);
        } else if (filePath.endsWith(".yml")) {
            file = yamlToMap(fullPath);
        }
        return  file;
    }
    public static Map<String, Object> yamlToMap(Path path) throws Exception {
        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(readString(path), new TypeReference<>() { });
    }
    public static Map<String, Object> jsonToMap(Path path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(readString(path), new TypeReference<Map<String, Object>>() { });
    }
    public static Path pathToFullPath(String path) throws Exception {
        String defaultPath = "src/main/resources";
        File file = new File(defaultPath);
        String absolutePath = file.getAbsolutePath();
        Path resultPath = Path.of(path);
        if (!path.startsWith("/")) {
            resultPath = Path.of(absolutePath + "/" + path);
        }
        if (new File(resultPath.toString()).exists()) {
            return resultPath;
        }
        throw new RuntimeException("Файл: " + resultPath + " не существует");
    }
}
