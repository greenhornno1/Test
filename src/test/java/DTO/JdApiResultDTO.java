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
public class JdApiResultDTO {
    private Number errorCode;
    private Number code;
    private String message;
    private String success;
    private Number callState;
    private Number resultCode;
    private String resultMessage;
}
