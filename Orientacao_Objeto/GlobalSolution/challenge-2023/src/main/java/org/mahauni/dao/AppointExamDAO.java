package org.mahauni.dao;

import java.util.List;

import org.mahauni.model.AppointExam;
import org.mahauni.model.ExamType;
import org.mahauni.model.User;

public interface AppointExamDAO {
    List<AppointExam> exams(ExamType examType);
}
