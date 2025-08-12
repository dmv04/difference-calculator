package io.github.dmv04.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.dmv04.Status;

import java.util.Map;

public class JsonFormatter {
    public static String getFormatted(Map<String, Status> difference) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(difference);
    }
}

