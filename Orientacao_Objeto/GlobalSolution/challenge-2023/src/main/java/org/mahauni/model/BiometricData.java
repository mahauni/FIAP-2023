package org.mahauni.model;

// Os dados vindos das tecnologias
// Leitura de sinais, dos dados do exame

// Ex: Exame de sangue, vai ter o dado do sangue etc.
public class BiometricData {
    private int id;
    private MedicalAppoint appoint;
    private HealthTech tech;
    private User user;
    private String data;

    // TODO the name we can take from the examType or make him type???

    public BiometricData() {
    }

    public BiometricData(MedicalAppoint appoint, HealthTech tech, User user, String data) {
        this.appoint = appoint;
        this.tech = tech;
        this.user = user;
        this.data = data;
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

    public HealthTech getTec() {
        return tech;
    }

    public void setTech(HealthTech tech) {
        this.tech = tech;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
