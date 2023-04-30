package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Link;

import java.util.List;


public class Json {
    public static String format(List<Link> mapsDifference) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(mapsDifference);
    }
}
