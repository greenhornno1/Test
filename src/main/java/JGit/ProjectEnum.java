package JGit;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum ProjectEnum {

    COMMON("common", "common_dependency"),
    COMMON_FOUNDATION("common-foundation", "common_dependency"),
    ETL("etl-job-service", "common_dependency"),
    MP_COMMON("mp-common", "mp"),
    MP_JD_STUB("mp-jd-stub", "mp"),
    MP_SHOPEE_STUB("mp-shopee-stub", "mp"),
    MP_LAZADA_STUB("mp-lazada-stub", "mp"),
    OP_STUB("op-order-service-stub", "mp"),
    MP_JD("mp-jd-service", "mp"),
    MP_SHOPEE("mp-shopee-service", "mp"),
    MP_LAZADA("mp-lazada-service", "mp"),
    OP("op-order-service", "mp"),
    MP_INTERNAL("mp-internal", "mp"),
    MP_TOKOPEDIA("mp-tokopedia-service", "mp"),
    MP_TOKOPEDIA_STUB("mp-tokopedia-stub", "mp"),
    MP_BLIBLI("mp-blibli-service", "mp"),
    MP_BLIBLI_STUB("mp-blibli-stub", "mp"),
    LOGISTICS("logistics-service", "logistics"),
    LOGISTICS_STUB("logistics-stub", "logistics"),
    LOGISTICS_AFTERSHIP_PM("logistics-aftership-postmen-service", "logistics"),
    LOGISTICS_AFTERSHIP_PM_STUB("logistics-aftership-postmen-stub", "logistics"),
    RETURN("return-service", "return"),
    RETURN_STUB("return-service-stub", "return");


    private String projectName;

    private String projectGroup;

    ProjectEnum(String projectName, String projectGroup) {
        this.projectName = projectName;
        this.projectGroup = projectGroup;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public String getProjectGroup() {
        return this.projectGroup;
    }

    public Boolean isMatchByName(String name) {
        return Objects.equals(this.projectName, name);
    }

    public Boolean isMatchByGroup(String group) {
        return Objects.equals(this.projectGroup, group);
    }

    public static Boolean isMatchByName(File name) {
        for (ProjectEnum p : ProjectEnum.values()) {
            if (p.isMatchByName(name.getName())) {
                return true;
            }
        }
        return false;
    }

    public static Boolean isMatchByGroup(File name, List<String> groups) {
        for (ProjectEnum p : ProjectEnum.values()) {
            if (p.isMatchByName(name.getName())) {
                if (groups != null && !groups.isEmpty()) {
                    for (String group : groups) {
                        if (p.isMatchByGroup(group)) {
                            return true;
                        }
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<ProjectEnum> logisticsProjects() {
        return Arrays.asList(ProjectEnum.LOGISTICS, ProjectEnum.LOGISTICS_STUB, ProjectEnum.LOGISTICS_AFTERSHIP_PM, ProjectEnum.LOGISTICS_AFTERSHIP_PM_STUB);
    }

//    public static List<ProjectEnum> mpProjects() {
//        return Arrays.asList(ProjectEnum.MP_COMMON, ProjectEnum.MP_INTERNAL, ProjectEnum.MP_JD, ProjectEnum.MP_JD_STUB,
//                ProjectEnum.MP_SHOPEE, ProjectEnum.MP_SHOPEE_STUB, ProjectEnum.MP_LAZADA, ProjectEnum.MP_LAZADA_STUB,
//                ProjectEnum.MP_TOKOPEDIA, ProjectEnum.MP_TOKOPEDIA_STUB, ProjectEnum.OP, ProjectEnum.OP_STUB);
//    }
//
//    public static List<ProjectEnum> commonProjects() {
//        return Arrays.asList(ProjectEnum.COMMON, ProjectEnum.COMMON_FOUNDATION, ProjectEnum.ETL);
//    }

}
