package hexlet.code.formatters;

import hexlet.code.Differ;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Stylish {
    public static void main(String[] args) throws Exception {
        System.out.println(Differ.generate("file3.json", "file4.json"));
    }
    private static final int INDEX_OF_TEMP_STRING_DATA = 13;
    private static final int INDEX_OF_REMOVED_STRINGS = 0;
    private static final int INDEX_OF_ADDED_STRINGS = 1;
    private static final int INDEX_OF_UNCHANGED_STRINGS = 2;
    private static final int INDEX_OF_UPDATED_STRINGS = 3;

    public static String getFormatted(List<Map<String, Object>> difference) {
        var sortedList = getStrings(difference);
        sortedList.sort(Comparator.comparing(o -> o.substring(2)));
        sortedList.sort((o1, o2) -> {
            int indexOfColon1 = o1.indexOf(':');
            int indexOfColon2 = o2.indexOf(':');
            if (o1.substring(2, indexOfColon1).equals(o2.substring(2, indexOfColon2))
                    && o1.charAt(0) == '-' && o2.charAt(0) == '+') {
                int index1 = sortedList.indexOf(o1);
                int index2 = sortedList.indexOf(o2);
                sortedList.set(index1, o2);
                sortedList.set(index2, o1);
            }
            return 0;
        });
        return "{\n  " + String.join("\n  ", sortedList) + "\n}";
    }

    private static ArrayList<String> getStrings(List<Map<String, Object>> difference) {
        var sortedList = new ArrayList<String>();

        var removed = difference.get(INDEX_OF_REMOVED_STRINGS);
        for (Map.Entry<String, Object> pair : removed.entrySet()) {
            sortedList.add("- " + pair.getKey() + ": " + pair.getValue());
        }
        var added = difference.get(INDEX_OF_ADDED_STRINGS);
        for (Map.Entry<String, Object> pair : added.entrySet()) {
            sortedList.add("+ " + pair.getKey() + ": " + pair.getValue());
        }
        var unchanged = difference.get(INDEX_OF_UNCHANGED_STRINGS);
        for (Map.Entry<String, Object> pair : unchanged.entrySet()) {
            sortedList.add("  " + pair.getKey() + ": " + pair.getValue());
        }
        var updated = difference.get(INDEX_OF_UPDATED_STRINGS);
        for (Map.Entry<String, Object> pair : updated.entrySet()) {
            if (pair.getKey().contains("old value")) {
                sortedList.add("- " + pair.getKey().substring(INDEX_OF_TEMP_STRING_DATA) + ": " + pair.getValue());
            } else if (pair.getKey().contains("new value")) {
                sortedList.add("+ " + pair.getKey().substring(INDEX_OF_TEMP_STRING_DATA) + ": " + pair.getValue());
            }
        }
        return sortedList;
    }
}
