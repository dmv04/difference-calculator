package hexlet.code;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static hexlet.code.DifferenceCalculator.getDifference;


public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String generate(String filepath1, String filepath2, String formatType) throws Exception {
        Map<String, Object> map1 = getData(filepath1);
        Map<String, Object> map2 = getData(filepath2);
        var differenceList = getDifference(map1, map2);
        return Formatter.getFormatted(differenceList, formatType);
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
        return index > 0 ? filePath.substring(index + 1) : "";
    }

}
