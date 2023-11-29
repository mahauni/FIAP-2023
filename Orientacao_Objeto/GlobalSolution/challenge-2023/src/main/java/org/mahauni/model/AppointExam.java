package org.mahauni.model;

public class AppointExam {
    private int id;
    private String name;
    private ExamType type;

    public AppointExam() {
    }

    public AppointExam(int id, String name, ExamType type) {
        this.id = id;
        this.name = name;
        this.type = type;
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

    public ExamType getType() {
        return type;
    }

    public void setType(ExamType type) {
        this.type = type;
    }
}
