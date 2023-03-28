package hexlet.code;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static hexlet.code.Differ.generate;


public class DifferTest {
    private static String getToFullPath(String path) {
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
    public void generateDefaultJsonTest() throws Exception {
        Path path = Paths.get("src/test/resources/stylishJsonTest");
        String expected = Files.readString(path);
        String nameFirstFile = "fileTest1.json";
        String nameSecondFile = "fileTest2.json";
        nameFirstFile = getToFullPath(nameFirstFile);
        nameSecondFile = getToFullPath(nameSecondFile);
        String actual = generate(nameFirstFile, nameSecondFile);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void generateDefaultYaml1Test() throws Exception {
        Path path = Paths.get("src/test/resources/stylishYml1Test");
        String expected = Files.readString(path);
        String nameFirstFile = "fileTest1.yml";
        String nameSecondFile = "fileTest2.yml";
        nameFirstFile = getToFullPath(nameFirstFile);
        nameSecondFile = getToFullPath(nameSecondFile);
        String actual = generate(nameFirstFile, nameSecondFile);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void generateDefaultYaml2Test() throws Exception {
        Path path = Paths.get("src/test/resources/stylishYml2Test");
        String expected = Files.readString(path);
        String nameFirstFile = "fileTest3.yml";
        String nameSecondFile = "fileTest4.yml";
        nameFirstFile = getToFullPath(nameFirstFile);
        nameSecondFile = getToFullPath(nameSecondFile);
        String actual = generate(nameFirstFile, nameSecondFile);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void generateJsonToPlainTest() throws Exception {
        Path path = Paths.get("src/test/resources/plainJsonTest");
        String expected = Files.readString(path);
        String nameFirstFile = "fileTest1.json";
        String nameSecondFile = "fileTest2.json";
        String format = "plain";
        nameFirstFile = getToFullPath(nameFirstFile);
        nameSecondFile = getToFullPath(nameSecondFile);
        String actual = generate(nameFirstFile, nameSecondFile, format);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void generateYmlToPlain1Test() throws Exception {
        Path path = Paths.get("src/test/resources/plainYml1Test");
        String expected = Files.readString(path);
        String nameFirstFile = "fileTest1.yml";
        String nameSecondFile = "fileTest2.yml";
        String format = "plain";
        nameFirstFile = getToFullPath(nameFirstFile);
        nameSecondFile = getToFullPath(nameSecondFile);
        String actual = generate(nameFirstFile, nameSecondFile, format);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void generateYmlToPlain2Test() throws Exception {
        Path path = Paths.get("src/test/resources/plainYml2Test");
        String expected = Files.readString(path);
        String nameFirstFile = "fileTest3.yml";
        String nameSecondFile = "fileTest4.yml";
        String format = "plain";
        nameFirstFile = getToFullPath(nameFirstFile);
        nameSecondFile = getToFullPath(nameSecondFile);
        String actual = generate(nameFirstFile, nameSecondFile, format);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void generateJsonToJsonTest() throws Exception {
        Path path = Paths.get("src/test/resources/jsonToJsonTest");
        String expected = Files.readString(path);
        String nameFirstFile = "fileTest1.json";
        String nameSecondFile = "fileTest2.json";
        String format = "json";
        nameFirstFile = getToFullPath(nameFirstFile);
        nameSecondFile = getToFullPath(nameSecondFile);
        String actual = generate(nameFirstFile, nameSecondFile, format);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void generateYmlToJson1Test() throws Exception {
        Path path = Paths.get("src/test/resources/jsonToYml1Test");
        String expected = Files.readString(path);
        String nameFirstFile = "fileTest1.yml";
        String nameSecondFile = "fileTest2.yml";
        String format = "json";
        nameFirstFile = getToFullPath(nameFirstFile);
        nameSecondFile = getToFullPath(nameSecondFile);
        String actual = generate(nameFirstFile, nameSecondFile, format);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void generateYmlToJson2Test() throws Exception {
        Path path = Paths.get("src/test/resources/jsonToYml2Test");
        String expected = Files.readString(path);
        String nameFirstFile = "fileTest3.yml";
        String nameSecondFile = "fileTest4.yml";
        String format = "json";
        nameFirstFile = getToFullPath(nameFirstFile);
        nameSecondFile = getToFullPath(nameSecondFile);
        String actual = generate(nameFirstFile, nameSecondFile, format);
        Assertions.assertEquals(expected, actual);
    }
}