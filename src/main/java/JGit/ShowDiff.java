package JGit;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;

import java.io.IOException;
import java.util.List;

@Slf4j
public class ShowDiff {
    public List<DiffEntry> getRepoDiff(Repository repository, Git git, Integer sprintNumber, String branch) throws GitAPIException, IOException {
        // the diff works on TreeIterators, we prepare two for the two branches
        AbstractTreeIterator oldTreeParser;
        AbstractTreeIterator newTreeParser;
//           AbstractTreeIterator oldTreeParser = prepareTreeParser(repo, "refs/remotes/origin/release");
//           AbstractTreeIterator newTreeParser = prepareTreeParser(repo, "refs/remotes/origin/master");
        if (branch != null) {
            String branchRepo = "refs/remotes/origin/" + branch;
            oldTreeParser = prepareTreeParser(repository, "refs/remotes/origin/release");
            newTreeParser = prepareTreeParser(repository, branchRepo);
        } else if (sprintNumber != null) {
            String sprintRepo = "refs/remotes/origin/sprints/develop-sprint" + sprintNumber;
            oldTreeParser = prepareTreeParser(repository, "refs/remotes/origin/release");
            newTreeParser = prepareTreeParser(repository, sprintRepo);
        } else {
            oldTreeParser = prepareTreeParser(repository, "refs/remotes/origin/master");
            newTreeParser = prepareTreeParser(repository, "refs/remotes/origin/release");
        }
        // then the procelain diff-command returns a list of diff entries
        List<DiffEntry> diff = git.diff().setOldTree(oldTreeParser).setNewTree(newTreeParser).call();
        for (DiffEntry entry : diff) {
            log.info("Entry: {}", entry);
        }
        return diff;
    }

    private AbstractTreeIterator prepareTreeParser(Repository repository, String ref) throws IOException {
        // from the commit we can build the tree which allows us to construct the TreeParser
//        String currentBranch = repository.getBranch();
        // "refs/heads/+currentBranch"
//        log.debug(ref);
        Ref head = repository.getRef(ref);
//        log.debug("All ref : {}", repository.getAllRefs());
        RevWalk walk = new RevWalk(repository);
//        log.debug("head : {}, walk : {}", head, walk);
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
            log.debug("prepareTreeParser {} finished.", ref);
        }
    }
}
