package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.JsonFormatter;

import java.util.List;
import java.util.Map;

public class Formatter {
    private static final String JSON = "json";
    private static final String PLAIN = "plain";
    private static final String STYLISH = "stylish";

    public static String getFormatted(List<Map<String, Object>> difference, String format) throws Exception {
        StringBuilder result = new StringBuilder();
        switch (format) {
            case JSON:
                result.append(JsonFormatter.getFormatted(difference));
                break;
            case PLAIN:
                result.append(Plain.getFormatted(difference));
                break;
            case STYLISH:
                result.append(Stylish.getFormatted(difference));
                break;
            default:
                throw new IllegalStateException("Unexpected format: " + format);
        }
        return result.toString();
    }
}
