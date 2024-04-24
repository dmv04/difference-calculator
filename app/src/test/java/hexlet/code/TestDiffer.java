package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiffer {
    @Test
    public void testGenerate1() throws Exception {
        var actual = generate("file3.json", "file4.json");
        Path path = Differ.pathToFullPath("expected/StylishExpected.txt");
        var expected = Files.readString(path);
        assertEquals(actual, expected);
    }

    @Test
    public void testGenerate2() throws Exception {
        var actual = generate("file3.yml", "file4.yml");
        Path path = Differ.pathToFullPath("expected/StylishExpected.txt");
        var expected = Files.readString(path);
        assertEquals(actual, expected);
    }

    @Test
    public void testGenerate3() throws Exception {
        var actual = generate("file3.json", "file4.json", FormatType.stylish);
        Path path = Differ.pathToFullPath("expected/StylishExpected.txt");
        var expected = Files.readString(path);
        assertEquals(actual, expected);
    }

    @Test
    public void testGenerate4() throws Exception {
        var actual = generate("file3.yml", "file4.yml", FormatType.stylish);
        Path path = Differ.pathToFullPath("expected/StylishExpected.txt");
        var expected = Files.readString(path);
        assertEquals(actual, expected);
    }

    @Test
    public void testGenerate5() throws Exception {
        var actual = generate("file3.json", "file4.json", FormatType.plain);
        Path path = Differ.pathToFullPath("expected/PlainExpected.txt");
        var expected = Files.readString(path);
        assertEquals(actual, expected);
    }

    @Test
    public void testGenerate6() throws Exception {
        var actual = generate("file3.yml", "file4.yml", FormatType.plain);
        Path path = Differ.pathToFullPath("expected/PlainExpected.txt");
        var expected = Files.readString(path);
        assertEquals(actual, expected);
    }

    @Test
    public void testGenerate7() throws Exception {
        var actual = generate("file3.json", "file4.json", FormatType.json);
        Path path = Differ.pathToFullPath("expected/JsonExpected.txt");
        var expected = Files.readString(path);
        assertEquals(actual, expected);
    }

    @Test
    public void testGenerate8() throws Exception {
        var actual = generate("file3.yml", "file4.yml", FormatType.json);
        Path path = Differ.pathToFullPath("expected/JsonExpected.txt");
        var expected = Files.readString(path);
        assertEquals(actual, expected);
    }

}
