package org.mahauni.model;

// Ferramenta que o hospital utiliza tipo assim
// Diagnostico do paciente

// ressonanica, raio X, exame de sangue, etc.
public class HealthTech {
    private int id;
    private String tecName;
    private String description;
    private ExamType examType;

    // Ratings.....
//    private List ratings;

    public HealthTech() {
    }

    public HealthTech(String tecName, String description, ExamType examType) {
        this.tecName = tecName;
        this.description = description;
        this.examType = examType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTecName() {
        return tecName;
    }

    public void setTecName(String tecName) {
        this.tecName = tecName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExamType getExamType() {
        return examType;
    }

    public void setExamType(ExamType examType) {
        this.examType = examType;
    }
}
