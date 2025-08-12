package io.github.dmv04.formatters;

import io.github.dmv04.Status;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

import static io.github.dmv04.Status.ADDED;
import static io.github.dmv04.Status.DELETED;
import static io.github.dmv04.Status.CHANGED;
import static io.github.dmv04.Status.UNCHANGED;


public class Plain {
    public static String getFormatted(Map<String, Status> difference) {
        var result = new ArrayList<String>();
        for (Map.Entry<String, Status> pair : difference.entrySet()) {
            switch (pair.getValue().getStatusName()) {
                case DELETED -> result.add("Property '" + pair.getKey() + "' was removed");
                case ADDED ->
                        result.add("Property '" + pair.getKey() + "' was added with value: "
                                + stringify(pair.getValue().getValue()));
                case CHANGED -> result.add("Property '" + pair.getKey() + "' was updated. From "
                        + stringify(pair.getValue().getOldValue()) + " to " + stringify(pair.getValue().getNewValue()));
                case UNCHANGED -> { }
                default -> throw new IllegalStateException("Unexpected value: " + pair.getValue().getStatusName());
            }
        }
        return String.join("\n", result);
    }

    private static String stringify(Object value) {
        if (value == null) {
            return "null";
        }

        if (value instanceof String) {
            return "'" + value + "'";
        }

        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        }

        return value.toString();
    }
}
