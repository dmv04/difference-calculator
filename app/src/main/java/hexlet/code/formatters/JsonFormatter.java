package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Status;

import java.util.Map;

public class JsonFormatter {
    public static String getFormatted(Map<String, Status> difference) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(difference);
    }
}

