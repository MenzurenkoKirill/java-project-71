package hexlet.code.formatters;

import hexlet.code.Link;
import java.util.List;

public class FormatSelection {
    public static String selectFormat(List<Link> mapsDifference, String formatName) throws Exception {
        return switch (formatName) {
            case "stylish" -> Stylish.format(mapsDifference);
            case "json" -> Json.format(mapsDifference);
            case "plain" -> Plain.format(mapsDifference);
            default -> throw new RuntimeException("Output format error, format - \"" + formatName + "\" "
                    + "is not processed!");
        };
    }
}
