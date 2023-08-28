import java.io.File;
import java.util.Objects;

public enum ProjectEnum {

    MP_COMMON("mp-common"),
    MP_JD("mp-jd-service"),
    MP_SHOPEE("mp-shopee-service"),
    MP_LAZADA("mp-lazada-service"),
    OP("op-order-service"),
    COMMON("common"),
    MP_JD_STUB("mp-jd-stub"),
    MP_SHOPEE_STUB("mp-shopee-stub"),
    MP_LAZADA_STUB("mp-lazada-stub"),
    OP_STUB("op-order-service-stub");

    private String projectName;

    ProjectEnum(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public Boolean isMatch(String name) {
        return Objects.equals(this.projectName, name);
    }

    public static Boolean isMatch(File name) {
        for (ProjectEnum p : ProjectEnum.values()) {
            if (p.isMatch(name.getName())) {
                return true;
            }
        }
        return false;
    }

}
