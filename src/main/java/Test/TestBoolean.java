package Test;

public class TestBoolean {


    private static final long serialVersionUID = 6539802532279095311L;

    private boolean success;

    private boolean needUpdate;

    private String errorMessage;

    private boolean needAlert;

    private String pushMetricsLogCommandJson;

    private Integer errorCode;

    public TestBoolean() {}

    public TestBoolean(boolean success, boolean needUpdate) {
        this.success = success;
        this.needUpdate = needUpdate;
    }

    public TestBoolean(boolean success, boolean needUpdate, String errorMessage) {
        this.success = success;
        this.needUpdate = needUpdate;
        this.errorMessage = errorMessage;
    }

    public TestBoolean(boolean success, boolean needUpdate, boolean needAlert,String pushMetricsLogCommandJson,String errorMessage) {
        this.success = success;
        this.needUpdate = needUpdate;
        this.needAlert = needAlert;
        this.pushMetricsLogCommandJson = pushMetricsLogCommandJson;
        this.errorMessage = errorMessage;
    }

    public TestBoolean(boolean success, boolean needUpdate,boolean needAlert,String pushMetricsLogCommandJson) {
        this.success = success;
        this.needUpdate = needUpdate;
        this.needAlert = needAlert;
        this.pushMetricsLogCommandJson = pushMetricsLogCommandJson;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isNeedUpdate() {
        return needUpdate;
    }

    public void setNeedUpdate(boolean needUpdate) {
        this.needUpdate = needUpdate;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


    public boolean isNeedAlert() {
        return needAlert;
    }

    public void setNeedAlert(boolean needAlert) {
        this.needAlert = needAlert;
    }

    public String getPushMetricsLogCommandJson() {
        return pushMetricsLogCommandJson;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setPushMetricsLogCommandJson(String pushMetricsLogCommandJson) {
        this.pushMetricsLogCommandJson = pushMetricsLogCommandJson;
    }
}
