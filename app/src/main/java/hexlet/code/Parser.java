package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Path;
import java.util.Map;

import static hexlet.code.Utils.getToFullPath;
import static java.nio.file.Files.readString;

public class Parser {
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
}
