package hexlet.code.formatters;

import hexlet.code.Status;

import java.util.ArrayList;
import java.util.Map;

import static hexlet.code.Status.ADDED;
import static hexlet.code.Status.UNCHANGED;
import static hexlet.code.Status.CHANGED;
import static hexlet.code.Status.DELETED;

public class Stylish {
    public static String getFormatted(Map<String, Status> difference) {
        var result = new ArrayList<String>();
        for (Map.Entry<String, Status> pair : difference.entrySet()) {
            switch (pair.getValue().getStatusName()) {
                case DELETED -> result.add("- " + pair.getKey() + ": " + pair.getValue().getValue());
                case ADDED -> result.add("+ " + pair.getKey() + ": " + pair.getValue().getValue());
                case UNCHANGED -> result.add("  " + pair.getKey() + ": " + pair.getValue().getValue());
                case CHANGED -> {
                    result.add("- " + pair.getKey() + ": " + pair.getValue().getOldValue());
                    result.add("+ " + pair.getKey() + ": " + pair.getValue().getNewValue());
                }
                default -> throw new IllegalStateException("Unexpected value: " + pair.getValue().getStatusName());
            }
        }
        return "{\n  " + String.join("\n  ", result) + "\n}";
    }
}
