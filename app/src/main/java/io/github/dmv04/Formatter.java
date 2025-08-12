package io.github.dmv04;

import io.github.dmv04.formatters.Plain;
import io.github.dmv04.formatters.Stylish;
import io.github.dmv04.formatters.JsonFormatter;

import java.util.Map;

public class Formatter {
    public static String getFormatted(Map<String, Status> difference, String formatType) throws Exception {
        StringBuilder result = new StringBuilder();
        switch (formatType) {
            case "json":
                result.append(JsonFormatter.getFormatted(difference));
                break;
            case "plain":
                result.append(Plain.getFormatted(difference));
                break;
            case "stylish":
                result.append(Stylish.getFormatted(difference));
                break;
            default:
                throw new IllegalStateException("Unexpected format: " + formatType);
        }
        return result.toString();
    }
}
