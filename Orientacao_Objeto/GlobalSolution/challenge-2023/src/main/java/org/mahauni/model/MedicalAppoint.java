package org.mahauni.model;

import java.sql.Date;

public class MedicalAppoint {
    private int id;
    private String name;
    private User patient;
    private ExamType type;
    private Pendency pendency;
    private Date appointTime;
    private String message;

    public MedicalAppoint() {
    }

    public MedicalAppoint(String name, User patient, ExamType type, Pendency pendency, Date appointTime, String message) {
        this.name = name;
        this.patient = patient;
        this.type = type;
        this.pendency = pendency;
        this.appointTime = appointTime;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public ExamType getType() {
        return type;
    }

    public void setType(ExamType type) {
        this.type = type;
    }

    public Pendency getPendency() {
        return pendency;
    }

    public void setPendency(Pendency pendency) {
        this.pendency = pendency;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MedicalAppoint{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", patient=" + patient +
                ", type=" + type +
                ", pendency=" + pendency +
                ", appointTime=" + appointTime +
                ", message='" + message + '\'' +
                '}';
    }
}
