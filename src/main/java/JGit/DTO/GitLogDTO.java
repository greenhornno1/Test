package JGit.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Builder
@Getter
public class GitLogDTO implements Serializable {

    private String commitHash;

    private String abbreviatedCommitHash;

    private CommitterDTO committer;

    private String fullMessage;

    private String shortMessage;

}
