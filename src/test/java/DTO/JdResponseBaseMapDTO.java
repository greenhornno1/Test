package DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JdResponseBaseMapDTO<T extends JdApiResultDTO> {
    private String code;
    private T apiResult;
    private T returnType;
    private T baseResult;
    private T baseEntity;
    private T retResult;
    private T data;
    private String message;
    private Boolean success;
}

