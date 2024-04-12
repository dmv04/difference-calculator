package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Map;


public class Parser {
    public static Map<String, Object> parse(String filepath) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        String content = Files.readString(path);
        return objectMapper.readValue(content, new TypeReference<>() {
        });
    }
}
