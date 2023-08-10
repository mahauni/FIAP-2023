package dao;

import model.Problem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProblemDAO {
    private Connection connection;

    public ProblemDAO(Connection connection) {
        this.connection = connection;
    }
    // make a way to have a boolean convert to either 0 or 1 based on false and true
    // finish this one marker
    public void insert(Problem Problem) {
        String sql = "INSERT INTO PROBLEMS(DESCRIPTION, COMPLETED, IDPERSON, IDESG) VALUES(?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, Problem.getDescription());
            stmt.setBoolean(2, Problem.isCompleted());
            stmt.setInt(3, Problem.getIdPerson());
            stmt.setInt(4, Problem.getIdEsg());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM PROBLEMS WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Problem Problem) {
        String sql = "UPDATE PROBLEMS SET DESCRIPTION=?, COMPLETED=?, IDPERSON=?, IDESG=?, WHERE ID=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, Problem.getDescription());
            stmt.setBoolean(2, Problem.isCompleted());
            stmt.setInt(3, Problem.getIdPerson());
            stmt.setInt(4, Problem.getIdEsg());
            stmt.setInt(6, Problem.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Problem> selectAll() {
        List<Problem> Problems = new ArrayList<>();
        String sql = "SELECT * FROM PROBLEMS";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Problem Problem = new Problem();
                Problem.setId(rs.getInt("ID"));
                Problem.setDescription(rs.getString("DESCRIPTION"));
                Problem.setCompleted(rs.getBoolean("COMPLETED"));
                Problem.setIdPerson(rs.getInt("IDPERSON"));
                Problem.setIdEsg(rs.getInt("IDESG"));

                Problems.add(Problem);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Problems;
    }

    public Problem selectById(int id) {
        Problem Problem = null;
        String sql = "SELECT * FROM PROBLEMS WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Problem = new Problem();
                Problem.setId(rs.getInt("ID"));
                Problem.setDescription(rs.getString("DESCRIPTION"));
                Problem.setCompleted(rs.getBoolean("COMPLETED"));
                Problem.setIdPerson(rs.getInt("IDPERSON"));
                Problem.setIdEsg(rs.getInt("IDESG"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Problem;
    }
}
