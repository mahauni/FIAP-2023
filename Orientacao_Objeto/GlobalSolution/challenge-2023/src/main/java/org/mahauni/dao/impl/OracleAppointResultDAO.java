package org.mahauni.dao.impl;

import org.mahauni.connection.ConnectionManager;
import org.mahauni.dao.AppointResultDAO;
import org.mahauni.model.AppointResult;
import org.mahauni.model.MedicalAppoint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleAppointResultDAO implements AppointResultDAO {
    private Connection connection;
    @Override
    public AppointResult getResult(MedicalAppoint appoint) {
        AppointResult appointResult = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = ConnectionManager.getInstance().getConnection();
            stmt = connection.prepareStatement("SELECT * FROM APPOINTMENT_RESULTS WHERE APPOINTMENT = ?");
            stmt.setInt(1, appoint.getId());
            rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("ID");
                String message = rs.getString("MESSAGE");

                appointResult = new AppointResult(appoint, message);
                appointResult.setId(id);

                return appointResult;
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
    public void createResult(AppointResult result) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = ConnectionManager.getInstance().getConnection();
            stmt = connection.prepareStatement("INSERT INTO APPOINTMENT_RESULTS (APPOINTMENT, MESSAGE) VALUES (?, ?)");
            stmt.setInt(1, result.getAppoint().getId());
            stmt.setString(2, result.getMessage());
            rs = stmt.executeQuery();

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
    }
}
