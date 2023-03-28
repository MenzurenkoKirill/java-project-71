package hexlet.code.formatters;

import hexlet.code.Link;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String formatPlain(List<Link> mapsDifference) {
        final StringBuilder sb = new StringBuilder();
        for (Link element : mapsDifference) {
            String key = element.getKey();
            String typeOfChange = element.getTypeOfChange();
            Object oldValue = element.getOldValue();
            Object newValue = element.getNewValue();
            switch (typeOfChange) {
                case ("added") :
                    sb.append("Property '")
                            .append(key)
                            .append("' was added with value: ")
                            .append(getValue(newValue))
                            .append("\n");
                    break;
                case ("deleted") :
                    sb.append("Property '")
                            .append(key)
                            .append("' was removed")
                            .append("\n");
                    break;
                case ("changed") :
                    sb.append("Property '")
                            .append(key)
                            .append("' was updated. From ")
                            .append(getValue(oldValue))
                            .append(" to ")
                            .append(getValue(newValue))
                            .append("\n");
                    break;
                case ("unchanged") :
                    break;
                default:
                    throw new RuntimeException("Error! Check the format of source files.");
            }
        }
        return sb.toString().trim();
    }
    private static String getValue(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        }
        if (value instanceof List || value instanceof Map) {
            return "[complex value]";
        }
        return String.valueOf(value);
    }
}
