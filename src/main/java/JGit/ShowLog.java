package JGit;

import JGit.DTO.CommitterDTO;
import JGit.DTO.GitLogDTO;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ShowLog {

    public List<GitLogDTO> getLog(Repository repository, Git git, Integer sprintNumber, String branch) throws GitAPIException, IOException {
        if (branch != null) {
            return getLogInfo(getOriginBranchReleaseLog(repository, git, branch));
        } else if (sprintNumber != null) {
            return getLogInfo(getOriginSprintReleaseLog(repository, git, sprintNumber));
        } else {
            return getLogInfo(getOriginMasterReleaseLog(repository, git));
        }
    }

    private Iterable<RevCommit> getOriginMasterReleaseLog(Repository repository, Git git) throws IOException, GitAPIException {
        log.info("get Log with origin Master - Release");
        return git.log()
                .add(repository.resolve("refs/remotes/origin/release"))
                .not(repository.resolve("refs/remotes/origin/master"))
                .call();
    }


    private Iterable<RevCommit> getOriginSprintReleaseLog(Repository repository, Git git, Integer sprintNumber) throws IOException, GitAPIException {
        log.info("get Log with origin Release - Sprint {}", sprintNumber);
        String sprintRepo = "refs/remotes/origin/sprints/develop-sprint" + sprintNumber.toString();
        return git.log()
                .add(repository.resolve(sprintRepo))
                .not(repository.resolve("refs/remotes/origin/release"))
                .call();
    }

    private Iterable<RevCommit> getOriginBranchReleaseLog(Repository repository, Git git, String branch) throws IOException, GitAPIException {
        log.info("get Log with origin Release - Branch {}", branch);
        String branchRepo = "refs/remotes/origin/" + branch;
        return git.log()
                .add(repository.resolve(branchRepo))
                .not(repository.resolve("refs/remotes/origin/release"))
                .call();
    }

    private List<GitLogDTO> getLogInfo(Iterable<RevCommit> logs) {
        List<GitLogDTO> logDTOList = new ArrayList<>();
        for (RevCommit rev : logs) {
            GitLogDTO dto = GitLogDTO.builder()
                    .commitHash(rev.getId().getName())
                    .abbreviatedCommitHash(rev.abbreviate(7).toString())
                    .fullMessage(rev.getFullMessage())
                    .shortMessage(rev.getShortMessage())
                    .committer(CommitterDTO.builder()
                            .name(rev.getCommitterIdent().getName())
                            .emailAddress(rev.getCommitterIdent().getEmailAddress())
                            .time(rev.getCommitterIdent().getWhen())
                            .timeZone(rev.getCommitterIdent().getTimeZone().getID())
                            .build())
                    .build();

            logDTOList.add(dto);

//            log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//            System.out.println(rev.getCommitterIdent());
//            System.out.println(rev.getCommitterIdent().getName());
//            System.out.println(rev.getCommitterIdent().getEmailAddress());
//            System.out.println(rev.getCommitterIdent().getTimeZone());
//            System.out.println(rev.getCommitterIdent().getWhen());
//            System.out.println(rev.getCommitterIdent().getTimeZoneOffset());
//            System.out.println(rev.getCommitterIdent().getClass());
//            System.out.println(rev.getId());
//            System.out.println("777777 : "+rev.abbreviate(7));
//            System.out.println(rev.getId().getName());
//            System.out.println(rev.getId().hashCode());
//            System.out.println(rev.getId().getFirstByte());
////            System.out.println(rev.getAuthorIdent());
//            System.out.println(rev.getFullMessage());
//            System.out.println(rev.getShortMessage());
////            System.out.println(rev.getCommitTime());
        }
        return logDTOList;
    }

    public List<String> printLogInfo(List<GitLogDTO> logDTOList) {
        List<String> result = new ArrayList<>();
        for (GitLogDTO dto : logDTOList) {
            String msg = String.format("%h - %s , %s %s : %s", dto.getAbbreviatedCommitHash(),
                    dto.getCommitter().getName(), dto.getCommitter().getTime(), dto.getCommitter().getTimeZone(),
                    dto.getShortMessage());

            log.info(msg);
            result.add(msg);
        }
        return result;
    }

}
