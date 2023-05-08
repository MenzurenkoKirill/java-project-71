package hexlet.code;

import java.util.List;
import java.util.Map;

import static hexlet.code.DataSupplier.getContentFromFile;
import static hexlet.code.DiffBuilder.getDiff;
import static hexlet.code.formatters.FormatSelection.selectFormat;


public class Differ {
    public static String generate(String firstPath, String secondPath, String formatName)
            throws Exception {
        Map<String, Object> data1 = getContentFromFile(firstPath);
        Map<String, Object> data2 = getContentFromFile(secondPath);
        List<Link> difference = getDiff(data1, data2);
        return selectFormat(difference, formatName);
    }
    public static String generate(String firstFileName, String secondFileName) throws Exception {
        return generate(firstFileName, secondFileName, "stylish");
    }
}
