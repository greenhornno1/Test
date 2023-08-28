import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JGitUtil {

    private Git git;
    private Repository repo;

    public Repository openRepo(Path repoPath) throws IOException {
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        return builder
                .setGitDir(Paths.get(String.valueOf(repoPath), ".git").toFile())
                .build();
    }

    public static Repository openJGitCookbookRepository() throws IOException {
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        return builder
                .readEnvironment() // scan environment GIT_* variables
                .findGitDir() // scan up the file system tree
                .build();
    }

    public void getRef() throws IOException {
        System.out.println(repo);
        Map<String,Ref> refList = repo.getAllRefs();
        System.out.println(refList);
    }

    public List<DiffEntry> getRepoDiff(Path repoPath) throws IOException, GitAPIException {
        try {
            this.repo = openRepo(repoPath);
            this.git = new Git(repo);

            // the diff works on TreeIterators, we prepare two for the two branches
//            AbstractTreeIterator oldTreeParser = prepareTreeParser(repo, "refs/remotes/origin/release");
//            AbstractTreeIterator newTreeParser = prepareTreeParser(repo, "refs/remotes/origin/master");
            AbstractTreeIterator oldTreeParser = prepareTreeParser(repo, "refs/remotes/origin/master");
            AbstractTreeIterator newTreeParser = prepareTreeParser(repo, "refs/remotes/origin/release");

            // then the procelain diff-command returns a list of diff entries
            List<DiffEntry> diff = git.diff().setOldTree(oldTreeParser).setNewTree(newTreeParser).call();
            for (DiffEntry entry : diff) {
                System.out.println("Entry: " + entry);
            }
            return diff;
        } finally {
            repo.close();
            git.close();
        }
    }

    public Iterator<RevCommit> getLog(Path repoPath) throws IOException, GitAPIException {
        try {
            this.repo = openRepo(repoPath);
            this.git = new Git(repo);

            Iterator<RevCommit> logIterator = git.log().call().iterator();
            for (; logIterator.hasNext(); ) {
                RevCommit logMessage = logIterator.next();
                System.out.println("Before revert: " + logMessage.getName() + " - " + logMessage.getFullMessage());
            }

                return logIterator;
            } finally {
            repo.close();
            git.close();
        }
    }

//    public void getLog(Path repoPath) throws IOException, GitAPIException {
//        try{
//            this.repo = openRepo(repoPath);
//            this.git = new Git(repo);
//
//            ArrayList<RevCommit> commits = new ArrayList<RevCommit>();
//
//
//        }
//    }

    private static AbstractTreeIterator prepareTreeParser(Repository repository, String ref) throws IOException {
        // from the commit we can build the tree which allows us to construct the TreeParser
//        String currentBranch = repository.getBranch();
        // "refs/heads/+currentBranch"
//        System.out.println(ref);
        Ref head = repository.getRef(ref);
//        System.out.println(repository.getAllRefs());
        RevWalk walk = new RevWalk(repository);
//        System.out.println(head);
//        System.out.println(walk);
        ObjectReader reader = repository.newObjectReader();
        try {
            RevCommit commit = walk.parseCommit(head.getObjectId());
            RevTree tree = walk.parseTree(commit.getTree().getId());

            CanonicalTreeParser treeParser = new CanonicalTreeParser();

            treeParser.reset(reader, tree.getId());

            return treeParser;
        } finally {
            walk.dispose();
            reader.release();
//            System.out.println("prepareTreeParser " + ref + " finished.");
        }
    }


//    public List<DiffEntry> getDiff(Path repoPath) throws Exception {
//        try {
//            AbstractTreeIterator oldTreeParser = prepareTreeParser(repo, "refs/heads/oldbranch");
//            AbstractTreeIterator newTreeParser = prepareTreeParser(repo, "refs/heads/master");
//
//            List<DiffEntry> diffList = git.diff()
//                    .setOldTree(oldTreeParser)
//                    .setNewTree(newTreeParser)
//                    .call();
//
//            return diffList;
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception("Get Diff Error: " + e.getMessage());
//        }
//    }

//    private static AbstractTreeIterator prepareTreeParser(Repository repository, String ref) throws IOException {
//        // from the commit we can build the tree which allows us to construct the TreeParser
//        Ref head = repository.exactRef(ref);
//        try (RevWalk walk = new RevWalk(repository)) {
//            RevCommit commit = walk.parseCommit(head.getObjectId());
//            RevTree tree = walk.parseTree(commit.getTree().getId());
//
//            CanonicalTreeParser treeParser = new CanonicalTreeParser();
//            try (ObjectReader reader = repository.newObjectReader()) {
//                treeParser.reset(reader, tree.getId());
//            }
//
//            walk.dispose();
//
//            return treeParser;
//        }
//    }

//    public void openRepo2(Path repoPath) throws Exception {
//        try {
//            Repository repository = new FileRepositoryBuilder()
//                    .setGitDir(Paths.get(String.valueOf(repoPath), ".git").toFile())
//                    .build();
//            this.repo = repository;
//            this.git = new Git(repository);
//            System.out.println(git);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception("Open Repo Error: " + e.getMessage());
//        }
//    }
//
//    public Path getProjectRepo(String dir, ProjectEnum projectEnum) throws Exception {
//        try {
//            List<Path> targetFolder =  Stream.of(new File(dir).listFiles())
//                    .filter(File::isDirectory)
//                    .filter(file -> projectEnum.isMatch(file.getName()))
//                    .map(File::toPath)
//                    .collect(Collectors.toList());
//
//            return targetFolder.get(0);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception("Get Repo Path Error: " + e.getMessage());
//        }
//    }
//
//    public Set<Path> getProjectRepo(String dir) throws Exception {
//        try {
//            return Stream.of(new File(dir).listFiles())
//                    .filter(File::isDirectory)
//                    .filter(ProjectEnum::isMatch)
//                    .map(File::toPath)
//                    .collect(Collectors.toSet());
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception("Get Repo Path Error: " + e.getMessage());
//        }
//    }
//
//    public void closeRepo() throws IOException{
//            this.repo.close();
//            this.git.close();
//    }

}
