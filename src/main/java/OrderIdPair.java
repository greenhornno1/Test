import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
@Setter
public class OrderIdPair {
    private String customerOrderId;
    private String externalOrderId;
}