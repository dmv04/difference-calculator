package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static hexlet.code.Parser.parse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {

    @Test
    void shouldReturnExpectedData() throws Exception {
        Path path = Differ.pathToFullPath("expected/JsonExpected.txt");
        var content = Files.readString(path);
        final Map<String, Object> actual = parse(content, "json");
        final Map<String, Object> expected = Map.of(
                "key_string", "value",
                "key_boolean", true,
                "key_integer", 1,
                "key_double", 1.2d
        );

        assertEquals(expected, actual);
    }
}
