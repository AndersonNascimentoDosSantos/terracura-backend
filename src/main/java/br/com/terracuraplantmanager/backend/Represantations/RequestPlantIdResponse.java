package br.com.terracuraplantmanager.backend.Represantations;

public class RequestPlantIdResponse {
    private String status;
    private Boolean sla_compliant_client;
    private Boolean sla_compliant_system;
    private Double created;
    private Double completed;
    private String access_token;
    private String model_version;

    private String custom_id;
    private Input input;
    private Result result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getSla_compliant_client() {
        return sla_compliant_client;
    }

    public void setSla_compliant_client(Boolean sla_compliant_client) {
        this.sla_compliant_client = sla_compliant_client;
    }

    public Boolean getSla_compliant_system() {
        return sla_compliant_system;
    }

    public void setSla_compliant_system(Boolean sla_compliant_system) {
        this.sla_compliant_system = sla_compliant_system;
    }

    public Double getCreated() {
        return created;
    }

    public void setCreated(Double created) {
        this.created = created;
    }

    public Double getCompleted() {
        return completed;
    }

    public void setCompleted(Double completed) {
        this.completed = completed;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getModel_version() {
        return model_version;
    }

    public void setModel_version(String model_version) {
        this.model_version = model_version;
    }

    public String getCustom_id() {
        return custom_id;
    }

    public void setCustom_id(String custom_id) {
        this.custom_id = custom_id;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
