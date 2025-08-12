package io.github.dmv04;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.TreeMap;

import static io.github.dmv04.Status.ADDED;
import static io.github.dmv04.Status.DELETED;
import static io.github.dmv04.Status.UNCHANGED;
import static io.github.dmv04.Status.CHANGED;

public class DifferenceCalculator {
    public static Map<String, Status> getDifference(
            Map<String, Object> parsedData1, Map<String, Object> parsedData2) {
        Set<String> set = new TreeSet<>();
        Map<String, Status> data = new TreeMap<>();

        set.addAll(parsedData1.keySet());
        set.addAll(parsedData2.keySet());

        for (String string : set) {
            if (!parsedData2.containsKey(string)) {
                data.put(string, new Status(DELETED, parsedData1.get(string)));
            } else if (!parsedData1.containsKey(string)) {
                data.put(string, new Status(ADDED, parsedData2.get(string)));
            } else if (String.valueOf(parsedData1.get(string)).equals(String.valueOf(parsedData2.get(string)))) {
                data.put(string, new Status(UNCHANGED, parsedData1.get(string)));
            } else if (!String.valueOf(parsedData1.get(string)).equals(String.valueOf(parsedData2.get(string)))) {
                data.put(string, new Status(CHANGED, parsedData1.get(string), parsedData2.get(string)));
            }
        }

        return data;
    }
}
