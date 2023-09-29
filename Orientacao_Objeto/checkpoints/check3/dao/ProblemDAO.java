package dao;

import model.Person;
import model.Problem;
import model.enumEsg;

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
        String sql = "INSERT INTO PROBLEMS(DESCRIPTION, COMPLETED, ID_PERSON, ID_ESG) VALUES(?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, Problem.getDescription());
            stmt.setInt(2, Problem.isCompleted());
            stmt.setInt(3, Problem.getIdPerson());
            stmt.setInt(4, Problem.getIdEsg());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM PROBLEMS WHERE ID_PROBLEM=?";
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
        String sql = "UPDATE PROBLEMS SET DESCRIPTION=?, COMPLETED=?, ID_PERSON=?, ID_ESG=? WHERE ID_PROBLEM=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, Problem.getDescription());
            stmt.setInt(2, Problem.isCompleted());
            stmt.setInt(3, Problem.getIdPerson());
            stmt.setInt(4, Problem.getIdEsg());
            stmt.setInt(5, Problem.getId());

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
                Problem.setId(rs.getInt("ID_PROBLEM"));
                Problem.setDescription(rs.getString("DESCRIPTION"));
                Problem.setCompleted(rs.getInt("COMPLETED"));
                Problem.setIdPerson(rs.getInt("ID_PERSON"));
                Problem.setIdEsg(rs.getInt("ID_ESG"));

                Problems.add(Problem);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Problems;
    }

    // execept for select all, all other use sql join
    public Problem selectById(int id) {
        Problem Problem = null;
        String sql = "SELECT * FROM PROBLEMS WHERE ID_PROBLEM = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Problem = new Problem();
                Problem.setId(rs.getInt("ID_PROBLEM"));
                Problem.setDescription(rs.getString("DESCRIPTION"));
                Problem.setCompleted(rs.getInt("COMPLETED"));
                Problem.setIdPerson(rs.getInt("ID_PERSON"));
                Problem.setIdEsg(rs.getInt("ID_ESG"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Problem;
    }


    public List<Problem> selectByEsgEnum(enumEsg esg) {
        List<Problem> problems = new ArrayList<>();
        String sql = "SELECT P.ID_PROBLEM, P.DESCRIPTION, P.COMPLETED, P.ID_PERSON, P.ID_ESG FROM ESG"
                + "INNER JOIN PROBLEMS P ON ESG.ID_ESG = P.ID_ESG"
                + "WHERE ESG.NAME_ESG = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(0, esg.toString());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Problem problem = new Problem();
                problem.setId(rs.getInt("ID_PROBLEM"));
                problem.setDescription(rs.getString("DESCRIPTION"));
                problem.setCompleted(rs.getInt("COMPLETED"));
                problem.setIdPerson(rs.getInt("ID_PERSON"));
                problem.setIdEsg(rs.getInt("ID_ESG"));
                problems.add(problem);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return problems;
    }


    public List<Problem> selectByPersonName(Person person) {
        List<Problem> problems = new ArrayList<>();
        String sql = "SELECT P.ID_PROBLEM, P.DESCRIPTION, P.COMPLETED, P.ID_PERSON, P.ID_ESG FROM PERSONS"
                + "INNER JOIN PROBLEMS P ON PERSONS.ID_PERSON = P.ID_PERSON"
                + "WHERE ESG.NAME_ESG = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(0, person.getName());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Problem problem = new Problem();
                problem.setId(rs.getInt("ID_PROBLEM"));
                problem.setDescription(rs.getString("DESCRIPTION"));
                problem.setCompleted(rs.getInt("COMPLETED"));
                problem.setIdPerson(rs.getInt("ID_PERSON"));
                problem.setIdEsg(rs.getInt("ID_ESG"));
                problems.add(problem);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return problems;
    }
}
