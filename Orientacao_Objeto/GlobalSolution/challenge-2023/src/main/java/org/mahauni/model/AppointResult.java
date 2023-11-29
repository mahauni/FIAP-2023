package org.mahauni.model;

public class AppointResult {
    private int id;
    private MedicalAppoint appoint;
    private String message;

    public AppointResult() {
    }

    public AppointResult(MedicalAppoint appoint, String message) {
        this.appoint = appoint;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MedicalAppoint getAppoint() {
        return appoint;
    }

    public void setAppoint(MedicalAppoint appoint) {
        this.appoint = appoint;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
