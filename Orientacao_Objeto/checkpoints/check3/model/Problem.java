package model;

public class Problem {
    private int id;
    private String description;
    private boolean completed;
    private int idPerson;
    private int idEsg;

    public Problem() {
    }

    public Problem(String description, boolean completed, int idPerson, int idEsg) {
        this.description = description;
        this.completed = completed;
        this.idPerson = idPerson;
        this.idEsg = idEsg;
    }

    public Problem(int id, String description, boolean completed, int idPerson, int idEsg) {
        this.id = id;
        this.description = description;
        this.completed = completed;
        this.idPerson = idPerson;
        this.idEsg = idEsg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getIdEsg() {
        return idEsg;
    }

    public void setIdEsg(int idEsg) {
        this.idEsg = idEsg;
    }
}
