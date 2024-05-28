package Entity;

public enum Status {
    A("active"), I("inactive");
    private String status;
    Status(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
