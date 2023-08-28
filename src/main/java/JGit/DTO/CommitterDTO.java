package JGit.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
@Builder
@Getter
public class CommitterDTO implements Serializable {

    private String name;

    private String emailAddress;

    private String timeZone;

    private Date time;

}
