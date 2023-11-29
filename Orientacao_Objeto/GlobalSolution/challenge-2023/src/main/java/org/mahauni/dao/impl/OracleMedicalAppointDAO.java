package org.mahauni.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.mahauni.connection.ConnectionManager;
import org.mahauni.dao.ExamTypeDAO;
import org.mahauni.dao.MedicalAppointDAO;
import org.mahauni.model.ExamType;
import org.mahauni.model.MedicalAppoint;
import org.mahauni.model.Pendency;
import org.mahauni.model.User;

public class OracleMedicalAppointDAO implements MedicalAppointDAO {
    private Connection connection;

    @Override
    public void registerAppointment(MedicalAppoint appoint) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = ConnectionManager.getInstance().getConnection();
            stmt = connection.prepareStatement("INSERT INTO APPOINTMENT (NAME, PATIENT, APPOINT_DATE, EXAM_TYPE, PENDENCY, MESSAGE) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, appoint.getName());
            stmt.setInt(2, appoint.getPatient().getId());
            stmt.setDate(3, appoint.getAppointTime());
            stmt.setInt(4, appoint.getType().getId());
            stmt.setString(5, appoint.getPendency().toString());
            stmt.setString(6, appoint.getMessage());
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
    public MedicalAppoint getAppointment(int id) {
        MedicalAppoint appoint = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = ConnectionManager.getInstance().getConnection();
            stmt = connection.prepareStatement("SELECT * FROM APPOINTMENT WHERE ID = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("NAME");
                int idPatient = rs.getInt("PATIENT");
                Date date = rs.getDate("APPOINT_DATE");
                int idType = rs.getInt("EXAM_TYPE");
                String pendency = rs.getString("PENDENCY");
                String message = rs.getString("MESSAGE");

                User user = new User();
                user.setId(idPatient);
                ExamType examType = new ExamType();
                examType.setId(idType);
                appoint = new MedicalAppoint(name, user, examType, Pendency.valueOf(pendency), date, message);
                appoint.setId(id);
            }

            return appoint;

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
    public void updateAppointment(MedicalAppoint appoint) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = ConnectionManager.getInstance().getConnection();
            stmt = connection.prepareStatement("UPDATE APPOINTMENT SET NAME = ?, PATIENT = ?, EXAM_TYPE = ?, PENDENCY = ?, APPOINT_DATE = ? WHERE ID = ?");
            stmt.setString(1, appoint.getName());
            stmt.setInt(2, appoint.getPatient().getId());
            stmt.setInt(3, appoint.getType().getId());
            stmt.setString(4, appoint.getPendency().toString());
            stmt.setDate(5, appoint.getAppointTime());
            stmt.setInt(6, appoint.getId());
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
    public List<MedicalAppoint> listRequestAppointments(User user) {
        List<MedicalAppoint> appoints = new ArrayList<MedicalAppoint>();
        PreparedStatement stmt = null;
        OracleExamTypeDAO examTypeDAO = new OracleExamTypeDAO();
        OracleUserDAO userDAO = new OracleUserDAO();
        ResultSet rs = null;

        try {
            connection = ConnectionManager.getInstance().getConnection();
//            stmt = connection.prepareStatement("SELECT * FROM APPOINTMENT WHERE PATIENT = ?");
            stmt = connection.prepareStatement("SELECT * FROM APPOINTMENT");
//            stmt.setInt(1, user.getId());
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                int idExamType = rs.getInt("EXAM_TYPE");
                int idPatient = rs.getInt("PATIENT");
                Pendency pendency = Pendency.valueOf(rs.getString("PENDENCY"));
                Date appointTime = rs.getDate("APPOINT_DATE");
                String message = rs.getString("MESSAGE");

                ExamType type = examTypeDAO.getExamTypeId(idExamType);

                User patient = userDAO.getUserById(idPatient);

                MedicalAppoint appoint = new MedicalAppoint(name, patient, type, pendency, appointTime, message);
                appoint.setId(id);
                appoints.add(appoint);
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

        return appoints;
    }

    @Override
    public List<MedicalAppoint> listExamAppointments() {
        List<MedicalAppoint> appoints = new ArrayList<MedicalAppoint>();
        PreparedStatement stmt = null;
        OracleExamTypeDAO examTypeDAO = new OracleExamTypeDAO();
        ResultSet rs = null;

        try {
            connection = ConnectionManager.getInstance().getConnection();
            stmt = connection.prepareStatement("SELECT * FROM APPOINTMENT WHERE PENDENCY = ? OR PENDENCY = ? OR PENDENCY = ?");
            stmt.setString(1, Pendency.PENDENT_MEDIC.toString());
            stmt.setString(2, Pendency.PENDENT_ANALIZE.toString());
            stmt.setString(3, Pendency.PENDENT_DATA.toString());
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idAppoint = rs.getInt("ID");
                String name = rs.getString("NAME");
                int idPatient = rs.getInt("PATIENT");
                int idExamType = rs.getInt("EXAM_TYPE");
                Pendency pendency = Pendency.valueOf(rs.getString("PENDENCY"));
                Date appointTime = rs.getDate("APPOINT_DATE");
                String message = rs.getString("MESSAGE");

                User patient = new User();
                patient.setId(idPatient);
                ExamType type = examTypeDAO.getExamTypeId(idExamType);

                MedicalAppoint appoint = new MedicalAppoint(name, patient, type, pendency, appointTime, message);
                appoint.setId(idAppoint);
                appoints.add(appoint);
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

        return appoints;
    }

    @Override
    public List<MedicalAppoint> listExamAppointmentsFinilized(User user) {
        List<MedicalAppoint> appoints = new ArrayList<MedicalAppoint>();
        PreparedStatement stmt = null;
        OracleExamTypeDAO examTypeDAO = new OracleExamTypeDAO();
        ResultSet rs = null;

        try {
            connection = ConnectionManager.getInstance().getConnection();
            stmt = connection.prepareStatement("SELECT * FROM APPOINTMENT WHERE PATIENT = ? AND PENDENCY = ?");
//            stmt = connection.prepareStatement("SELECT * FROM APPOINTMENT");
            stmt.setInt(1, user.getId());
            stmt.setString(2, Pendency.FINILIZED.toString());
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                int idExamType = rs.getInt("EXAM_TYPE");
                Pendency pendency = Pendency.valueOf(rs.getString("PENDENCY"));
                Date appointTime = rs.getDate("APPOINT_DATE");
                String message = rs.getString("MESSAGE");

                ExamType type = examTypeDAO.getExamTypeId(idExamType);

                MedicalAppoint appoint = new MedicalAppoint(name, user, type, pendency, appointTime, message);
                appoint.setId(id);
                appoints.add(appoint);
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

        return appoints;
    }

    @Override
    public void deleteAppoint(int id) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = ConnectionManager.getInstance().getConnection();
            stmt = connection.prepareStatement("DELETE FROM APPOINTMENT WHERE ID = ?");
            stmt.setInt(1, id);
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
