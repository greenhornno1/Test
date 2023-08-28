package Test.Lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LombokDTO {

    public final static String EMAIL_RECIPIENT_SEPARATOR = ",;";
    public final static String EMAIL_GROUP_NAME_SEPARATOR = ",;";

    String subject;
    Set<String> to = new LinkedHashSet<>();
    Set<String> cc = new LinkedHashSet<>();
    Set<String> bcc = new LinkedHashSet<>();
    String emailBody;

}
