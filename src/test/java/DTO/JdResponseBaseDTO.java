package DTO;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;


@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JdResponseBaseDTO<T extends JdApiResultDTO>  {

    private Map<String, JdResponseBaseMapDTO<T>> map = new HashMap<>();
    private String errorMessage;
    private String errorSolution;
    private String code;
    @JsonProperty("error_response")
    private JdErrorResponseDTO errorResponse;
    private JdApiResultDTO apiResult;

    @JsonAnySetter
    public void add(String key, JdResponseBaseMapDTO<T> value) {
        map.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, JdResponseBaseMapDTO<T>> getMap() {
        return map;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public T getApiResultDTO() {
        if (map.isEmpty()) {
            return null;
        }
        AtomicReference<T> result = new AtomicReference<>();
        map.entrySet().stream()
                .findAny()
                .ifPresent(jdResponseBaseMapEntry ->
                        result.set((T) Arrays.stream(jdResponseBaseMapEntry.getValue().getClass().getDeclaredFields())
                                .peek(field -> field.setAccessible(true))
                                .map(field -> {
                                            try {
                                                return field.get(jdResponseBaseMapEntry.getValue());
                                            } catch (IllegalAccessException e) {
                                                System.out.println("[JD] cast error for function: "
                                                        + jdResponseBaseMapEntry.getKey());
                                            }
                                            return null;
                                        }
                                )
                                .filter(JdApiResultDTO.class::isInstance)
                                .findAny()
                                .orElse(null))
                );
        return result.get();
    }

    @JsonIgnore
    public boolean isResponseSuccess() {
        return Optional.ofNullable(getApiResultDTO())
                .map(JdApiResultDTO::getSuccess)
                .map(Boolean::parseBoolean)
                .orElse(false);
    }


    @JsonIgnore
    public String getJDApiMessage() {
        return Optional.ofNullable(getApiResultDTO())
                .map(JdApiResultDTO::getMessage)
                .orElse(errorMessage);
    }
}
