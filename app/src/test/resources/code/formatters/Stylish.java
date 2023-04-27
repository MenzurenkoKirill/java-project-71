package code.formatters;

import hexlet.code.Link;

import java.util.List;

public class Stylish {
    public static String format(List<Link> mapsDifference)
            throws Exception {
        final StringBuilder sb = new StringBuilder("{\n");
        for (Link element : mapsDifference) {
            String key = element.getKey();
            String typeOfChange = element.getTypeOfChange();
            Object oldValue = element.getOldValue();
            Object newValue = element.getNewValue();
            switch (typeOfChange) {
                case ("added"):
                    sb.append("  + ")
                            .append(key)
                            .append(": ")
                            .append(newValue)
                            .append("\n");
                    break;
                case ("deleted"):
                    sb.append("  - ")
                            .append(key)
                            .append(": ")
                            .append(oldValue)
                            .append("\n");
                    break;
                case ("changed"):
                    sb.append("  - ")
                            .append(key)
                            .append(": ")
                            .append(oldValue)
                            .append("\n")
                            .append("  + ")
                            .append(key)
                            .append(": ")
                            .append(newValue)
                            .append("\n");
                    break;
                case ("unchanged"):
                    sb.append("    ")
                            .append(key)
                            .append(": ")
                            .append(newValue)
                            .append("\n");
                    break;
                default:
                    throw new RuntimeException("Error! Check the format of source files.");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
