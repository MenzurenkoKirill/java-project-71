package hexlet.code;

import java.nio.file.Path;
import java.util.Map;

import static hexlet.code.Parser.retrieveData;
import static hexlet.code.Utils.getFullPath;
import static java.nio.file.Files.readString;


public class DataSupplier {
    public static Map<String, Object> getContentFromFile(String filePath) throws Exception {
        Path absolutePath = getFullPath(filePath);
        String contentFromFile = readString(absolutePath);
        return retrieveData(absolutePath, contentFromFile);
    }
}
