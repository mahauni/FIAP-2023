package model;

public enum enumEsg {
    ENVIRONMENTAL("Environmental"),
    SOCIAL("Social"),
    GOVERNMENTAL("Governmental");

    private String details;

    enumEsg(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }
}
