package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.JsonFormatter;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String getFormatted(List<Map<String, Object>> difference, FormatType formatType) throws Exception {
        StringBuilder result = new StringBuilder();
        switch (formatType) {
            case json:
                result.append(JsonFormatter.getFormatted(difference));
                break;
            case plain:
                result.append(Plain.getFormatted(difference));
                break;
            case stylish:
                result.append(Stylish.getFormatted(difference));
                break;
            default:
                throw new IllegalStateException("Unexpected format: " + formatType);
        }
        return result.toString();
    }
}
