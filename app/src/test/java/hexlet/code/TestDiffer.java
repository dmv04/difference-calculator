package hexlet.code;

import org.junit.jupiter.api.Test;


import static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestDiffer {
    @Test
    public void testGenerate() throws Exception {
        var actual = generate("build/resources/main/file1.json", "build/resources/main/file2.json");
        var expected = "- follow: false\n"
                + "  host: hexlet.io\n"
                + "- proxy: 123.234.53.22\n"
                + "- timeout: 50\n"
                + "+ timeout: 20\n"
                + "+ verbose: true";
        assertEquals(actual, expected);
    }
}
