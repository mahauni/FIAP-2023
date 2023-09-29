package model;

public class Esg {
    private int id;
    private model.enumEsg enumEsg;
    private String description;

    public Esg() {
    }

    public Esg(int id, model.enumEsg enumEsg, String description) {
        this.id = id;
        this.enumEsg = enumEsg;
        this.description = description;
    }

    public Esg(model.enumEsg enumEsg, String description) {
        this.enumEsg = enumEsg;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public model.enumEsg getEsg() {
        return enumEsg;
    }

    public void setEsg(model.enumEsg enumEsg) {
        this.enumEsg = enumEsg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Esg{" +
                "id=" + id +
                ", enumEsg=" + enumEsg +
                ", description='" + description + '\'' +
                '}';
    }
}
