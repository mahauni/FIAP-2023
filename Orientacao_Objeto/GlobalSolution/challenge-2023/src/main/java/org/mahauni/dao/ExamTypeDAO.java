package org.mahauni.dao;

import org.mahauni.model.ExamType;

public interface ExamTypeDAO {
    ExamType getExamType(String name);

    ExamType getExamTypeId(int id);
}
