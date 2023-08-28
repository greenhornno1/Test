package Util.JsonUtil;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

//@Slf4j
@UtilityClass
public class JsonHelper {
    private static final ObjectMapper JACKSON_OBJECT_MAPPER = new ObjectMapper();

    static {
        // Disable throwing exception when unknown properties are received
        JACKSON_OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // Access case insensitive properties
        JACKSON_OBJECT_MAPPER.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        JACKSON_OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        JACKSON_OBJECT_MAPPER.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        JACKSON_OBJECT_MAPPER.findAndRegisterModules();
    }

    public static Map<String, String> convertToMap(@NonNull String input) {
        Map<String, String> resultMap;
        try {
            resultMap = JACKSON_OBJECT_MAPPER.readValue(input, new TypeReference<Map<String,String>>(){});
        } catch (IOException e) {
            System.out.println("Unable to convert JSON for string: " + input);
            e.printStackTrace();
            resultMap = Collections.emptyMap();
        }
        return resultMap;
    }

    public static <T> T convertToPojo(@NonNull String input, Class<T> klazz) {
        T result;
        try {
            result = JACKSON_OBJECT_MAPPER.readValue(input, klazz);
        } catch (IOException e) {
            System.out.println("Unable to convert JSON for string: " + input);
            e.printStackTrace();
            result = null;
        }
        return result;
    }

    public static <T> T convertToPojoUnchecked(@NonNull String input, Class<T> klazz) throws IOException {
        return JACKSON_OBJECT_MAPPER.readValue(input, klazz);
    }

    public static String convertToString(@NonNull Object input) {
        String resultJson;
        try {
            resultJson = JACKSON_OBJECT_MAPPER.writeValueAsString(input);
        } catch (JsonProcessingException e) {
            System.out.println("Unable to convert Object to JSON String " + input);
            e.printStackTrace();
            resultJson = "";
        }
        return resultJson;
    }
}

