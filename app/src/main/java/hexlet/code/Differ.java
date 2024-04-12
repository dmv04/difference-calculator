package hexlet.code;

import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        Set<String> set = new TreeSet<>();
        LinkedList<String> resultList = new LinkedList<>();

        Map<String, Object> map1 = Parser.parse(filepath1);
        Map<String, Object> map2 = Parser.parse(filepath2);

        set.addAll(map1.keySet());
        set.addAll(map2.keySet());

        for (String string : set) {
            if (!map2.containsKey(string)) {
                resultList.add("- " + string + ": " + map1.get(string));
            } else if (!map1.containsKey(string)) {
                resultList.add("+ " + string + ": " + map2.get(string));
            } else if (map1.get(string).equals(map2.get(string))) {
                resultList.add("  " + string + ": " + map1.get(string));
            } else if (!map1.get(string).equals(map2.get(string))) {
                resultList.add("- " + string + ": " + map1.get(string));
                resultList.add("+ " + string + ": " + map2.get(string));
            }
        }
        return resultList.stream().map(string -> string + "\n").collect(Collectors.joining()).trim();
    }
}
