package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static hexlet.code.Differ.generate;

public class DifferTest {

    private static String expectedStylish;
    private static String expectedPlain;
    private static String expectedJson;

    @BeforeAll
    public static void init() throws IOException {
        expectedStylish = Files.readString(Path.of(toFullPath("Expected_Stylish.txt")));
        expectedPlain = Files.readString(Path.of(toFullPath("Expected_Plain.txt")));
        expectedJson = Files.readString(Path.of(toFullPath("Expected_Json.txt")));
    }
    private final String nameFirstFileJson = toFullPath("fileTest1.json");
    private final String nameSecondFileJson = toFullPath("fileTest2.json");
    private final String nameFirstFileYml = toFullPath("fileTest1.yml");
    private final String nameSecondFileYml = toFullPath("fileTest2.yml");

    public DifferTest() throws IOException {
    }

    private static String toFullPath(String path) {
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
    public void stylishFromJsonWithoutArgTest() throws Exception {
        String actual = generate(nameFirstFileJson, nameSecondFileJson);
        assertThat(actual).isEqualTo(expectedStylish);
    }

    @Test
    public void stylishFromJsonWithArgTest() throws Exception {
        String actual = generate(nameFirstFileJson, nameSecondFileJson, "stylish");
        assertThat(actual).isEqualTo(expectedStylish);
    }

    @Test
    public void stylishFromYmlWithoutArgTest() throws Exception {
        String actual = generate(nameFirstFileYml, nameSecondFileYml);
        assertThat(actual).isEqualTo(expectedStylish);
    }

    @Test
    public void stylishFromYmlWithArgTest() throws Exception {
        String actual = generate(nameFirstFileYml, nameSecondFileYml, "stylish");
        assertThat(actual).isEqualTo(expectedStylish);
    }

    @Test
    public void plainFromJsonTest() throws Exception {
        String actual = generate(nameFirstFileJson, nameSecondFileJson, "plain");
        assertThat(actual).isEqualTo(expectedPlain);
    }

    @Test
    public void plainFromYmlTest() throws Exception {
        String actual = generate(nameFirstFileYml, nameSecondFileYml, "plain");
        assertThat(actual).isEqualTo(expectedPlain);
    }

    @Test
    public void jsonFromJsonTest() throws Exception {
        String actual = generate(nameFirstFileJson, nameSecondFileJson, "json");
        assertThat(actual).isEqualTo(expectedJson);
    }

    @Test
    public void jsonFromYmlTest() throws Exception {
        String actual = generate(nameFirstFileYml, nameSecondFileYml, "json");
        assertThat(actual).isEqualTo(expectedJson);
    }
}
