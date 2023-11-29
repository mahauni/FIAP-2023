package org.mahauni.model;

public class Rating {
    private int id;
    private User patient;
    private HealthTech tech;
    private int rating;

    public Rating() {
    }

    public Rating(User patient, HealthTech tech, int rating) {
        this.patient = patient;
        this.tech = tech;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public HealthTech getTech() {
        return tech;
    }

    public void setTech(HealthTech tech) {
        this.tech = tech;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
