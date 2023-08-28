package Test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrackingNumberDTO {
    private String boxId;
    private String trackingNo;
    private Boolean success;
    private Teacher teacher;
}
