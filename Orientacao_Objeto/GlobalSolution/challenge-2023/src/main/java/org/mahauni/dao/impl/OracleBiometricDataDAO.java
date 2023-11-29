package org.mahauni.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.mahauni.connection.ConnectionManager;
import org.mahauni.dao.BiometricDataDAO;
import org.mahauni.model.*;

public class OracleBiometricDataDAO implements BiometricDataDAO {
    private Connection connection;

    @Override
    public void registerBioData(BiometricData biometric) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // Talvez precise adicionar alguma coisa a mais?
            connection = ConnectionManager.getInstance().getConnection();
            stmt = connection.prepareStatement("INSERT INTO BIOMETRIC_DATA (APPOINTMENT, TYPE_TECH, PATIENT, DESCRIPTION) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, biometric.getAppoint().getId());
            stmt.setInt(2, biometric.getTec().getId());
            stmt.setInt(3, biometric.getUser().getId());
            stmt.setString(4, biometric.getData());

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

    @Override
    public List<BiometricData> getAppointBioData(MedicalAppoint appoint) {
        List<BiometricData> biometricDataList = new ArrayList<BiometricData>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // Talvez precise adicionar alguma coisa a mais?
            connection = ConnectionManager.getInstance().getConnection();
            stmt = connection.prepareStatement("SELECT * FROM BIOMETRIC_DATA WHERE APPOINTMENT = ?");
            stmt.setInt(1, appoint.getId());

            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
//                int idAppoint = rs.getInt("APPOINTMENT");
                int idTypeTech = rs.getInt("TYPE_TECH");
                int idPatient = rs.getInt("PATIENT");
                String description = rs.getString("DESCRIPTION");

                HealthTech tech = new HealthTech();
                tech.setId(idTypeTech);

                User patient = new User();
                patient.setId(idPatient);

                BiometricData biometricData = new BiometricData(appoint, tech, patient, description);
                biometricData.setId(id);

                biometricDataList.add(biometricData);
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
        return biometricDataList;
    }
}
