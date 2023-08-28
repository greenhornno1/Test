package map.util;

import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@UtilityClass
public class MapUtil {
    public Map<String, Object> toMap(Object object) {
        Map<String, Object> map = new HashMap<>();
        if (Objects.nonNull(object)) {
            for (Field field : object.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    map.put(field.getName(), field.get(object));
                } catch (Exception ignored) {
                }
            }
        }
        return map;
    }
}