package org.mahauni.dao.impl;

import org.mahauni.connection.ConnectionManager;
import org.mahauni.dao.UserDAO;
import org.mahauni.model.HealthTech;
import org.mahauni.model.User;
import org.mahauni.model.UserType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleUserDAO implements UserDAO {
    private Connection connection;

    @Override
    public boolean validateUser(User user) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = ConnectionManager.getInstance().getConnection();
            stmt = connection.prepareStatement("SELECT * FROM PEOPLE WHERE EMAIL = ? AND PASSWORD = ?");
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPassword());
            rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
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
        return false;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = ConnectionManager.getInstance().getConnection();
            stmt = connection.prepareStatement("SELECT * FROM PEOPLE WHERE EMAIL = ?");
            stmt.setString(1, email);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                email = rs.getString("EMAIL");
                String password = rs.getString("PASSWORD");
                UserType type = UserType.valueOf(rs.getString("TYPE"));

                user = new User(name, email, password, type);
                user.setId(id);

                return user;
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
        return user;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = ConnectionManager.getInstance().getConnection();
            stmt = connection.prepareStatement("SELECT * FROM PEOPLE WHERE ID = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String email = rs.getString("EMAIL");
                String password = rs.getString("PASSWORD");
                UserType type = UserType.valueOf(rs.getString("TYPE"));

                user = new User(name, email, password, type);
                user.setId(id);

                return user;
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
        return user;
    }

    @Override
    public void createUser(User user) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = ConnectionManager.getInstance().getConnection();
            stmt = connection.prepareStatement("INSERT INTO PEOPLE (NAME, EMAIL, PASSWORD, TYPE) VALUES (?, ?, ?, ?)");
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getType().toString());
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
