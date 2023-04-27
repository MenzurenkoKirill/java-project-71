package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static hexlet.code.Differ.generate;

public class DifferTest {

    private final String expectedStylish = Files.readString(Path.of(getToFullPath("Expected_Stylish.txt")));
    private final String expectedPlain = Files.readString(Path.of(getToFullPath("Expected_Plain.txt")));
    private final String expectedJson = Files.readString(Path.of(getToFullPath("Expected_Json.txt")));

    private final String nameFirstFileJson = (getToFullPath("fileTest1.json"));
    private final String nameSecondFileJson = (getToFullPath("fileTest2.json"));
    private final String nameFirstFileYml = (getToFullPath("fileTest1.yml"));
    private final String nameSecondFileYml = (getToFullPath("fileTest2.yml"));

    public DifferTest() throws IOException {
    }

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
    public void stylishFromJsonTest() throws Exception {
        String actual = generate(nameFirstFileJson, nameSecondFileJson);
        assertThat(actual).isEqualTo(expectedStylish);
    }

    @Test
    public void stylishFromYmlTest() throws Exception {
        String actual = generate(nameFirstFileYml, nameSecondFileYml);
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
