package hexlet.code;

import java.io.File;
import java.lang.reflect.Array;
import java.nio.file.Path;
public class Utils {
    private static final String DEFAULT_PATH = "src/main/resources";
    public static Path getFullPath(String filePath) throws Exception {
        File file = new File(DEFAULT_PATH);
        String absolutePathForFile = file.getAbsolutePath();
        Path resultPath = Path.of(filePath);
        if (!filePath.startsWith("/")) {
            resultPath = Path.of(absolutePathForFile + "/" + filePath);
        }
        return resultPath;
    }
    public static String extractFilename(Path absolutePath) {
        String absolutePathString = absolutePath.toString();
        String[] partsOfAbsolutePath =  new String[absolutePathString.split("/").length];
        partsOfAbsolutePath = absolutePathString.split("/");
        return partsOfAbsolutePath[Array.getLength(partsOfAbsolutePath) - 1];
    }
}
