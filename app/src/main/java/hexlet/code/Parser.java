package hexlet.code;

import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class Parser {
    public static Map<String, Object> retrieveData(String extension, String fileContent) throws Exception {
        Map<String, Object> file = null;
        if (extension.contains("json")) {
            file = convertJsonToMap(fileContent);
        } else if (extension.contains("yml")) {
            file = convertYamlToMap(fileContent);
        }
        return  file;
    }
    public static Map<String, Object> convertYamlToMap(String fileContent) throws Exception {
        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(fileContent, new TypeReference<>() { });
    }
    public static Map<String, Object> convertJsonToMap(String fileContent) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(fileContent, new TypeReference<>() { });
    }
}
