import JGit.Util.FileHelper;
import JGit.Util.JGitHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.StringUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

@Slf4j
public class JGitMain {

    public static void main(String[] args) {
        final String oldIndex = "C:\\ASWAS";
        final String index = "C:\\ASWASNew";
        final String logIndex = "C:\\Users\\Sophie.Chow\\Desktop\\History\\History\\deploy\\ALL";
        final String logFileName = "gitLog";
        final String diffFileName = "diffList";
        FileHelper fileHelper = new FileHelper();
        List<String> logList = new ArrayList<>();
        List<String> diffList = new ArrayList<>();

        final String COMMON = "common_dependency";
        final String MP = "mp";
        final String LOGISTICS = "logistics";
        final String RETURN = "return";

        final String DEV = "develop";
        final String SIT = "sit";

        // One project
//        try (JGitHelper jGitHelper = new JGitHelper()) {
//            ProjectEnum targetRepo = ProjectEnum.COMMON;
//            Path repoPath = fileHelper.getProjectRepo(index, targetRepo);
//            System.out.println("RepoPath :" + repoPath);
//            log.debug("Checking : {}", repoPath);
//            logList.add(repoPath.toString());
//            diffList.add(repoPath.toString());
//            jGitHelper.setProject(repoPath);
//            jGitHelper.showRef();
//            diffList.addAll(jGitHelper.getRepoDiff());
//            logList.addAll(jGitHelper.getLog());
//            fileHelper.writeText(fileHelper.createFile(logIndex,logFileName),logList);
//            fileHelper.writeText(fileHelper.createFile(logIndex,diffFileName),diffList);
//        } catch (Exception e) {
//            log.error("Error :", e);
//        }

        Integer sprintNumber = null;
        String branch = null;

        // Loop all project
        try (JGitHelper jGitHelper = new JGitHelper()) {
//            Set<Path> RepoPathAll = fileHelper.getProjectRepo(index);
            List<String> groups = Arrays.asList(LOGISTICS, COMMON);
            String serviceGroup = String.join("+", groups);
            Set<Path> RepoPathAll = fileHelper.getProjectRepoByGroup(index, groups);
            log.debug("All repository : {}", RepoPathAll);
            for (Path repoPath : RepoPathAll) {
                log.debug("Checking : {}", repoPath);
                logList.add(repoPath.toString().replaceAll("C:\\\\ASWASNew", ""));
                diffList.add(repoPath.toString().replaceAll("C:\\\\ASWASNew", ""));
                jGitHelper.setProject(repoPath);
//                jGitHelper.showRef();
                if (branch != null) {
                    String log = "Compare origin/" + "branch" + " to origin/release";
                    diffList.add(log);
                    logList.add(log);
                } else if (sprintNumber != null) {
                    diffList.add("Compare origin/sprints/develop-sprint" + sprintNumber + " to origin/release");
                    logList.add("Compare origin/sprints/develop-sprint" + sprintNumber + " to origin/release");
                } else {
                    diffList.add("Compare origin/master to origin/release");
                    logList.add("Compare origin/master to origin/release");
                }
                try {
                    diffList.addAll(jGitHelper.getRepoDiff(sprintNumber, branch));
                    logList.addAll(jGitHelper.getLog(sprintNumber, branch));
                } catch (Exception e) {
                    log.error("Error in {} ", repoPath, e);
                }
                jGitHelper.close();
                diffList.add("\r\n");
                logList.add("\r\n");
            }
            Path pp = fileHelper.writeText(fileHelper.createFile(logIndex, logFileName, sprintNumber, serviceGroup), logList);
            Path ppp = fileHelper.writeText(fileHelper.createFile(logIndex, diffFileName, sprintNumber, serviceGroup), diffList);
            log.info("log write to {} and {}", pp, ppp);
        } catch (Exception e) {
            log.error("Error :", e);
        }
    }

}

