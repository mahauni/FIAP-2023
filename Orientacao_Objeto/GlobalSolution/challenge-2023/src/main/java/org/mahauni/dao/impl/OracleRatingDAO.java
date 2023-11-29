package org.mahauni.dao.impl;

import org.mahauni.connection.ConnectionManager;
import org.mahauni.dao.RatingDAO;
import org.mahauni.model.*;

import java.io.Serial;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleRatingDAO implements RatingDAO {
    private Connection connection;

    @Override
    public void rateTech(Rating rating) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = ConnectionManager.getInstance().getConnection();
            stmt = connection.prepareStatement("INSERT INTO RATINGS (PATIENT, TECHNOLOGY, RATING) VALUES (?, ?, ?)");
            stmt.setInt(1, rating.getPatient().getId());
            stmt.setInt(2, rating.getTech().getId());
            stmt.setInt(3, rating.getRating());
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
    public List<Rating> getRatings(HealthTech tech) {
        List<Rating> ratings = new ArrayList<Rating>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = ConnectionManager.getInstance().getConnection();
            stmt = connection.prepareStatement("SELECT * FROM APPOINT_EXAMS WHERE TECHNOLOGY = ?");
            stmt.setInt(1, tech.getId());
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                int idPatient = rs.getInt("PATIENT");
                int ratingNum = rs.getInt("RATING");

                User patient = new User();
                patient.setId(idPatient);

                Rating rating = new Rating(patient, tech, ratingNum);
                rating.setId(id);

                ratings.add(rating);
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

        return ratings;
    }
}
