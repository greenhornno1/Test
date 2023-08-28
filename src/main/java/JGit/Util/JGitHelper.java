package JGit.Util;

import JGit.ShowDiff;
import JGit.ShowLog;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class JGitHelper implements AutoCloseable {

    private Git git;
    private Repository repo;


    public Repository openRepo(Path repoPath) throws IOException {
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        return builder
                .setGitDir(Paths.get(String.valueOf(repoPath), ".git").toFile())
                .build();
    }

    public List<String> getRepoDiff(Integer sprintNumber, String branch) throws GitAPIException, IOException {
        ShowDiff showDiff = new ShowDiff();
        return showDiff.getRepoDiff(this.repo, this.git, sprintNumber, branch).stream().map(Object::toString).collect(Collectors.toList());
    }

    public List<String> getLog(Integer sprintNumber, String branch) throws GitAPIException, IOException {
        ShowLog showLog = new ShowLog();
        return showLog.printLogInfo(showLog.getLog(this.repo, this.git, sprintNumber, branch));
    }

    /**
     * List all references of git repository
     * Need to setProjectRepo() before calling showRef()
     */
    public void showRef() {
        Map<String, Ref> refList = this.repo.getAllRefs();
        log.debug(String.valueOf(refList));
    }

    public void setProject(Path repoPath) throws IOException {
        setProjectRepo(repoPath);
        setProjectGit();
    }

    public void setProjectGit() {
        this.git = new Git(this.repo);
    }

    public void setProjectRepo(Path repoPath) throws IOException {
        this.repo = openRepo(repoPath);
    }

    public void closeRepo() {
        log.debug("{} closed.", Optional.ofNullable(this.repo.getDirectory()));
        this.repo.close();
    }

    public void closeGit() {
        log.debug("{} closed.", Optional.ofNullable(this.git.getClass()));
        this.git.close();
    }

    @Override
    public void close() {
        log.debug("{} closed.", Optional.ofNullable(this.repo.getDirectory()));
        log.debug("{} closed.", Optional.ofNullable(this.git.getClass()));
        this.git.close();
        this.repo.close();
    }
}
