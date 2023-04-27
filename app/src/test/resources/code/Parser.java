package code;

import java.nio.file.Path;
import java.util.Map;

import static hexlet.code.Differ.convertJsonToMap;
import static hexlet.code.Differ.convertYamlToMap;

public class Parser {
    public static Map<String, Object> retrieveData(Path fullFilePath) throws Exception {
        Map<String, Object> file = null;
        if (fullFilePath.toString().endsWith(".json")) {
            file = Differ.convertJsonToMap(fullFilePath);
        } else if (fullFilePath.toString().endsWith(".yml")) {
            file = Differ.convertYamlToMap(fullFilePath);
        }
        return  file;
    }
}
