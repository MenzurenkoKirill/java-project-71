package hexlet.code;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {
    private static final String DEFAULT_PATH = "src/main/resources";
    public static Path getFullPath(String filePath) throws Exception {
        Path path = Paths.get(filePath);
        if (path.isAbsolute()) {
            return path;
        }
        return path.toAbsolutePath().normalize();
    }
}
