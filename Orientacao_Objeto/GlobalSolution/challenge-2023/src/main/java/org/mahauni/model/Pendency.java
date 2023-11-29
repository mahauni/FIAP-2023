package org.mahauni.model;

public enum Pendency {
    PENDENT_MEDIC("Pendente aceitacao do medico"),
    PENDENT_DATA("Pendente dados biometricos do paciente"),
    PENDENT_ANALIZE("Pendente analise medica"),
    FINILIZED("Finalizado");

    private String details;

    Pendency(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }
}
