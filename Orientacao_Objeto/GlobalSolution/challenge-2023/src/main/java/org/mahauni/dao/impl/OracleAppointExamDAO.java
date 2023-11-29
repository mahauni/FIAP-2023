package org.mahauni.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mahauni.connection.ConnectionManager;
import org.mahauni.dao.AppointExamDAO;
import org.mahauni.model.AppointExam;
import org.mahauni.model.ExamType;

public class OracleAppointExamDAO implements AppointExamDAO {
    private Connection connection;

    @Override
    public List<AppointExam> exams(ExamType examType) {
        List<AppointExam> exams = new ArrayList<AppointExam>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = ConnectionManager.getInstance().getConnection();
            stmt = connection.prepareStatement("SELECT * FROM APPOINTMENT_EXAMS WHERE TYPE_EXAM = ?");
            stmt.setInt(1, examType.getId());
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");



                AppointExam exam = new AppointExam(id, name, examType);

                exams.add(exam);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return exams;
    }
}
