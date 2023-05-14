package hexlet.code.formatters;

import hexlet.code.Link;
import java.util.List;

public class FormatSelection {
    public static String selectFormat(List<Link> difference, String formatName) throws Exception {
        return switch (formatName) {
            case "stylish" -> Stylish.format(difference);
            case "json" -> Json.format(difference);
            case "plain" -> Plain.format(difference);
            default -> throw new RuntimeException("Output format error, format - \"" + formatName + "\" "
                    + "is not processed!");
        };
    }
}
