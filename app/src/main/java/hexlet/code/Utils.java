package hexlet.code;

import java.io.File;
import java.nio.file.Path;

public class Utils {
    private static final String DEFAULT_PATH = "src/main/resources";
    public static Path getToFullPath(String filePath) throws Exception {
        File file = new File(DEFAULT_PATH);
        String absolutePathForFile = file.getAbsolutePath();
        Path resultPath = Path.of(filePath);
        if (!filePath.startsWith("/")) {
            resultPath = Path.of(absolutePathForFile + "/" + filePath);
        }
        return resultPath;
    }
}
