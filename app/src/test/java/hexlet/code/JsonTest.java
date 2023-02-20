package hexlet.code;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;


public class JsonTest {
    private final String expectationForJson = "{\"- age\":\"24\",\"+ age\":\"25\",\"+ graduation\":\"yes\","
            + "\"  name\":\"Kirill\",\"- post\":\"design engineer\",\"+ post\":\"java programmer\","
            + "\"- study\":\"yes\",\"  surname\":\"Menzurenko\"}";
    private final String expectationForYml = "{\"- age\":24,\"+ age\":25,\"+ graduation\":true,"
            + "\"  name\":\"Kirill\",\"- post\":\"design engineer\",\"+ post\":\"java programmer\","
            + "\"- study\":true,\"  surname\":\"Menzurenko\"}";

    @Test
    public void generateTestJson() throws Exception {
        String filePathTest1 = "fileTest1.json";
        String filePathTest2 = "fileTest2.json";
        filePathTest1 = pathToFullPath(filePathTest1);
        filePathTest2 = pathToFullPath(filePathTest2);
        String actual = Parser.generate(filePathTest1, filePathTest2);
        Assertions.assertEquals(expectationForJson, actual);
    }

    private static String pathToFullPath(String path) throws Exception {
        String defaultPath = "src/test/resources";
        File file = new File(defaultPath);
        String absolutePath = file.getAbsolutePath();
        Path resultPath = Path.of(path);
        if (!path.startsWith("/home")) {
            return absolutePath + "/" + path;
        }
        throw new RuntimeException("Файл: " + resultPath + " не существует");
    }
    @Test
    public void generateTestYml() throws Exception {
        String filePathTest1 = "fileTest1.yml";
        String filePathTest2 = "fileTest2.yml";
        filePathTest1 = pathToFullPath(filePathTest1);
        filePathTest2 = pathToFullPath(filePathTest2);
        String actual = Parser.generate(filePathTest1, filePathTest2);
        Assertions.assertEquals(expectationForYml, actual);
    }
}
