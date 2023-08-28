package JGit.Util;

import JGit.ProjectEnum;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class FileHelper {

    final SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss");

    public Path getProjectRepo(String dir, ProjectEnum projectEnum) throws Exception {
        try {
            List<Path> targetFolder = Stream.of(Objects.requireNonNull(new File(dir).listFiles()))
                    .filter(File::isDirectory)
                    .filter(file -> projectEnum.isMatchByName(file.getName()))
                    .map(File::toPath)
                    .collect(Collectors.toList());

            return targetFolder.get(0);
        } catch (Exception e) {
            log.error("Failed to get Get Repository", e);
            throw new Exception("Get Repo Path Error: " + e.getMessage());
        }
    }

    public Set<Path> getProjectRepo(String dir) throws Exception {
        try {
            return Stream.of(Objects.requireNonNull(new File(dir).listFiles()))
                    .filter(File::isDirectory)
                    .filter(ProjectEnum::isMatchByName)
                    .map(File::toPath)
                    .collect(Collectors.toSet());
        } catch (Exception e) {
            log.error("Failed to get Get Repository", e);
            throw new Exception("Get Repo Path Error: " + e.getMessage());
        }
    }

    public Set<Path> getProjectRepoByGroup(String dir, List<String> groups) throws Exception {
        try {
            return Stream.of(Objects.requireNonNull(new File(dir).listFiles()))
                    .filter(File::isDirectory)
                    .filter(project -> ProjectEnum.isMatchByGroup(project, groups))
                    .map(File::toPath)
                    .collect(Collectors.toSet());
        } catch (Exception e) {
            log.error("Failed to get Get Repository", e);
            throw new Exception("Get Repo Path Error: " + e.getMessage());
        }
    }

    public Path writeText(Path filePath, List<String> content) throws IOException {
        return Files.write(filePath, content);
    }

    public Path createFile(String index, String filename, Integer sprintNumber, String serviceGroup) throws IOException {
        String sprint;
        if (sprintNumber == null) {
            sprint = "master-release";
        } else {
            sprint = "sprint" + sprintNumber + "-release";
        }
        Path path = Paths.get(index, serviceGroup + "-" + filename + "-" + sprint + "-" + formatter.format(new Date()) + ".txt");
        return Files.createFile(path);
    }
}
