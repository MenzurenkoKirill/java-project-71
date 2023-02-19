package hexlet.code;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import hexlet.code.Parser.*;

import java.io.File;
import java.nio.file.Path;
import java.util.Map;


public class jsonFormatTest {
    private final String expectation = "{\"- age\":\"24\",\"+ age\":\"25\",\"+ graduation\":\"yes\"," +
            "\"  name\":\"Kirill\",\"- post\":\"design engineer\",\"+ post\":\"java programmer\"," +
            "\"- study\":\"yes\",\"  surname\":\"Menzurenko\"}";

    @Test
    public void generateTest() throws Exception {
        String filePathTest1 = "fileTest1.json";
        String filePathTest2 = "fileTest2.json";
        filePathTest1 = pathToFullPath(filePathTest1);
        filePathTest2 = pathToFullPath(filePathTest2);
        String actual = Parser.generate(filePathTest1, filePathTest2);
        Assertions.assertEquals(expectation, actual);
    }
    private static String pathToFullPath(String path) throws Exception {
        String defaultPath = "src/test/resources";
        File file = new File(defaultPath);
        String absolutePath = file.getAbsolutePath();
        Path resultPath = Path.of(path);
        if(!path.startsWith("/home")) {
            return absolutePath + "/" + path;
        }
        throw new RuntimeException("Файл: " + resultPath + " не существует");
    }

}
