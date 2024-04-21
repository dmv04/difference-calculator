package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Map;


public class Parser {
    public static Map<String, Object> parse(String filepath) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Path path = pathToFullPath(filepath);
        String content = Files.readString(path);
        return objectMapper.readValue(content, new TypeReference<>() {
        });
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
}
