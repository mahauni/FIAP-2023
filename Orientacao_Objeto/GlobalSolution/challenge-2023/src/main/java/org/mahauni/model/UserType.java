package org.mahauni.model;

public enum UserType {
    PATIENT("Patient"),
    MEDIC("Medic");

    private String details;

    UserType(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }
}
