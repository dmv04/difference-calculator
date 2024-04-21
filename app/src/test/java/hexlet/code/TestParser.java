package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static hexlet.code.Parser.parse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestParser {
    @Test
    public void testParse() throws Exception {
        var actual = parse("file1.json");
        var expected = new HashMap<String, Object>();
        expected.put("host", "hexlet.io");
        expected.put("timeout", 50);
        expected.put("proxy", "123.234.53.22");
        expected.put("follow", false);
        assertEquals(actual, expected);
    }
}
