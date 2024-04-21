package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Differ;

import java.util.Map;
import java.util.List;


public class JsonFormatter {
    public static void main(String[] args) throws Exception {
        System.out.println(Differ.generate("file3.json", "file4.json", "json"));
    }

    public static String getFormatted(List<Map<String, Object>> difference) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(difference);
    }
}

