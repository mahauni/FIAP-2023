package org.mahauni.dao.impl;

import jdk.jshell.spi.ExecutionControl;
import org.mahauni.connection.ConnectionManager;
import org.mahauni.dao.HealthTechDAO;
import org.mahauni.model.ExamType;
import org.mahauni.model.HealthTech;
import org.mahauni.model.Rating;
import org.mahauni.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleHealthTechDAO implements HealthTechDAO {
    private Connection connection;

    @Override
    public void requestTech(HealthTech tech) {
//        throw new ExecutionControl.NotImplementedException("Not implemented yet");
    }

    @Override
    public List<HealthTech> getTech() {
        List<HealthTech> techList = new ArrayList<HealthTech>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = ConnectionManager.getInstance().getConnection();
            stmt = connection.prepareStatement("SELECT * FROM TECHNOLOGIES");
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String description = rs.getString("DESCRIPTION");
                int idExamType = rs.getInt("EXAM_TYPE");

                ExamType examType = new ExamType();
                examType.setId(idExamType);

                HealthTech tech = new HealthTech(name, description, examType);
                tech.setId(id);

                techList.add(tech);
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

        return techList;
    }

    @Override
    public HealthTech getTechByName(String name) {
        HealthTech tech = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = ConnectionManager.getInstance().getConnection();
            stmt = connection.prepareStatement("SELECT * FROM TECHNOLOGIES WHERE NAME = ?");
            stmt.setString(1, name);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("ID");
                name = rs.getString("NAME");
                String description = rs.getString("DESCRIPTION");
                int idExamType = rs.getInt("EXAM_TYPE");

                ExamType examType = new ExamType();
                examType.setId(idExamType);

                tech = new HealthTech(name, description, examType);
                tech.setId(id);

                return tech;
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

        return tech;
    }

    @Override
    public List<HealthTech> getTechByExamType(ExamType examType) {
        List<HealthTech> techs = new ArrayList<HealthTech>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = ConnectionManager.getInstance().getConnection();
            stmt = connection.prepareStatement("SELECT * FROM TECHNOLOGIES WHERE EXAM_TYPE = ?");
            stmt.setInt(1, examType.getId());
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String description = rs.getString("DESCRIPTION");
                int idExamType = rs.getInt("EXAM_TYPE");

                HealthTech tech = new HealthTech(name, description, examType);
                tech.setId(id);

                techs.add(tech);

            }

            return techs;
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

        return techs;
    }
}
