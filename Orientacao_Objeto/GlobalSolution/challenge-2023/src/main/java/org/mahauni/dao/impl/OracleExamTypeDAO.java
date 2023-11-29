package org.mahauni.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mahauni.connection.ConnectionManager;
import org.mahauni.dao.ExamTypeDAO;
import org.mahauni.model.ExamType;

public class OracleExamTypeDAO implements ExamTypeDAO {
    private Connection connection;

    @Override
    public ExamType getExamType(String name) {
        ExamType examType = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = ConnectionManager.getInstance().getConnection();
            stmt = connection.prepareStatement("SELECT * FROM EXAMS_TYPE WHERE NAME_EXAM = ?");
            stmt.setString(1, name);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int idExamType = rs.getInt("ID");
                String nameExam = rs.getString("NAME_EXAM");

                examType = new ExamType(idExamType, name);

                return examType;
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
        return null;
    }

    @Override
    public ExamType getExamTypeId(int id) {
        ExamType examType = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = ConnectionManager.getInstance().getConnection();
            stmt = connection.prepareStatement("SELECT * FROM EXAMS_TYPE WHERE ID = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int idExamType = rs.getInt("ID");
                String nameExam = rs.getString("NAME_EXAM");

                examType = new ExamType(idExamType, nameExam);

                return examType;
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
        return null;
    }
}
