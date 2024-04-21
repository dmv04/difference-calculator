package hexlet.code;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedHashMap;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        Set<String> set = new TreeSet<>();
        LinkedList<Map<String, Object>> differenceList = new LinkedList<>();
        var removed = new LinkedHashMap<String, Object>();
        var added = new LinkedHashMap<String, Object>();
        var unchanged = new LinkedHashMap<String, Object>();
        var updated = new LinkedHashMap<String, Object>();

        Map<String, Object> map1 = getData(filepath1);
        Map<String, Object> map2 = getData(filepath2);

        set.addAll(map1.keySet());
        set.addAll(map2.keySet());

        for (String string : set) {
            if (!map2.containsKey(string)) {
                removed.put(string, map1.get(string));
            } else if (!map1.containsKey(string)) {
                added.put(string, map2.get(string));
            } else if (String.valueOf(map1.get(string)).equals(String.valueOf(map2.get(string)))) {
                unchanged.put(string, map1.get(string));
            } else if (!String.valueOf(map1.get(string)).equals(String.valueOf(map2.get(string)))) {
                updated.put("old value of " + string, map1.get(string));
                updated.put("new value of " + string, map2.get(string));
            }
        }

        differenceList.add(removed);
        differenceList.add(added);
        differenceList.add(unchanged);
        differenceList.add(updated);

        return Formatter.getFormatted(differenceList, "stylish");
    }

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Set<String> set = new TreeSet<>();
        LinkedList<Map<String, Object>> differenceList = new LinkedList<>();
        var removed = new LinkedHashMap<String, Object>();
        var added = new LinkedHashMap<String, Object>();
        var unchanged = new LinkedHashMap<String, Object>();
        var updated = new LinkedHashMap<String, Object>();

        Map<String, Object> map1 = getData(filepath1);
        Map<String, Object> map2 = getData(filepath2);

        set.addAll(map1.keySet());
        set.addAll(map2.keySet());

        for (String string : set) {
            if (!map2.containsKey(string)) {
                removed.put(string, map1.get(string));
            } else if (!map1.containsKey(string)) {
                added.put(string, map2.get(string));
            } else if (String.valueOf(map1.get(string)).equals(String.valueOf(map2.get(string)))) {
                unchanged.put(string, map1.get(string));
            } else if (!String.valueOf(map1.get(string)).equals(String.valueOf(map2.get(string)))) {
                updated.put("old value of " + string, map1.get(string));
                updated.put("new value of " + string, map2.get(string));
            }
        }

        differenceList.add(removed);
        differenceList.add(added);
        differenceList.add(unchanged);
        differenceList.add(updated);
        return Formatter.getFormatted(differenceList, format);
    }

    private static Map<String, Object> getData(String filePath) throws Exception {
        Path fullPath = pathToFullPath(filePath);
        if (!Files.exists(fullPath)) {
            throw new Exception("File '" + fullPath + "' does not exist");
        }
        String content = Files.readString(fullPath);
        String dataFormat = getDataFormat(filePath);
        return Parser.parse(content, dataFormat);
    }

    public static Path pathToFullPath(String path) {
        String path1 = "src/main/resources";
        File file = new File(path1);
        String absolutePath = file.getAbsolutePath();
        Path resultPath = Path.of(path);
        if (!path.startsWith("/")) {
            resultPath = Path.of(absolutePath + "/" + path);
        }
        if (new File(resultPath.toString()).exists()) {
            return resultPath;
        }
        throw new RuntimeException("File: " + resultPath + " does not exist");
    }
    private static String getDataFormat(String filePath) {
        int index = filePath.lastIndexOf('.');
        return index > 0
                ? filePath.substring(index + 1)
                : "";
    }
}
