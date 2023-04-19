package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
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
/*        Path path = Paths.get("src/test/resources/stylishJsonTest");
        String expected = Files.readString(path);*/
        String expected = """
                {
                  - age: 24
                  + age: 25
                  + graduation: true
                    name: Kirill
                  - post: design engineer
                  + post: java programmer
                  - study: true
                    surname: Menzurenko
                }""";
        String nameFirstFile = "fileTest1.json";
        String nameSecondFile = "fileTest2.json";
        nameFirstFile = getToFullPath(nameFirstFile);
        nameSecondFile = getToFullPath(nameSecondFile);
        String actual = generate(nameFirstFile, nameSecondFile);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void generateDefaultYaml1Test() throws Exception {
/*        Path path = Paths.get("src/test/resources/stylishYml1Test");
        String expected = Files.readString(path);*/
        String expected = """
                {
                  - age: 24
                  + age: 25
                  + graduation: true
                    name: Kirill
                  - post: design engineer
                  + post: java programmer
                  - study: true
                    surname: Menzurenko
                }""";
        String nameFirstFile = "fileTest1.yml";
        String nameSecondFile = "fileTest2.yml";
        nameFirstFile = getToFullPath(nameFirstFile);
        nameSecondFile = getToFullPath(nameSecondFile);
        String actual = generate(nameFirstFile, nameSecondFile);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void generateDefaultYaml2Test() throws Exception {
/*        Path path = Paths.get("src/test/resources/stylishYml2Test");
        String expected = Files.readString(path);*/
        String expected = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";
        String nameFirstFile = "fileTest3.yml";
        String nameSecondFile = "fileTest4.yml";
        nameFirstFile = getToFullPath(nameFirstFile);
        nameSecondFile = getToFullPath(nameSecondFile);
        String actual = generate(nameFirstFile, nameSecondFile);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void generateJsonToPlainTest() throws Exception {
/*        Path path = Paths.get("src/test/resources/plainJsonTest");
        String expected = Files.readString(path);*/
        String expected = """
                Property 'age' was updated. From '24' to '25'
                Property 'graduation' was added with value: 'true'
                Property 'post' was updated. From 'design engineer' to 'java programmer'
                Property 'study' was removed""";
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
/*        Path path = Paths.get("src/test/resources/plainYml1Test");
        String expected = Files.readString(path);*/
        String expected = """
                Property 'age' was updated. From 24 to 25
                Property 'graduation' was added with value: true
                Property 'post' was updated. From 'design engineer' to 'java programmer'
                Property 'study' was removed""";
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
        /*Path path = Paths.get("src/test/resources/plainYml2Test");
        String expected = Files.readString(path);*/
        String expected = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'""";
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