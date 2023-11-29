package org.mahauni.dao;

import org.mahauni.model.ExamType;
import org.mahauni.model.HealthTech;

import java.util.List;

public interface HealthTechDAO {
    void requestTech(HealthTech tech);

    List<HealthTech> getTech();

    HealthTech getTechByName(String name);

    List<HealthTech> getTechByExamType(ExamType examType);
}
