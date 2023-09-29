package dao;

import model.Esg;
import model.enumEsg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EsgDAO {

    private Connection connection;

    public EsgDAO(Connection connection) {
        this.connection = connection;
    }
    public void insert(Esg Esg) {
        String sql = "INSERT INTO ESG(NAME_ESG, DESCRIPTION) VALUES(?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, Esg.getEsg().toString());
            stmt.setString(2, Esg.getDescription());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM ESG WHERE ID_ESG=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // maybe do something that only this one can set the id and others not
    public void update(Esg Esg) {
        String sql = "UPDATE ESG SET NAME_ESG=?, DESCRIPTION=? WHERE ID_ESG=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, Esg.getEsg().toString());
            stmt.setString(2, Esg.getDescription());
            stmt.setInt(3, Esg.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Esg> selectAll() {
        List<Esg> Esgs = new ArrayList<>();
        String sql = "SELECT * FROM ESG";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Esg Esg = new Esg();
                Esg.setId(rs.getInt("ID_ESG"));
                Esg.setEsg(enumEsg.valueOf(rs.getString("NAME_ESG")));
                Esg.setDescription(rs.getString("DESCRIPTION"));

                Esgs.add(Esg);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Esgs;
    }

    public Esg selectById(int id) {
        Esg Esg = null;
        String sql = "SELECT * FROM ESG WHERE ID_ESG=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Esg = new Esg();
                Esg.setId(rs.getInt("ID_ESG"));
                Esg.setEsg(enumEsg.valueOf(rs.getString("NAME_ESG")));
                Esg.setDescription(rs.getString("DESCRIPTION"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Esg;
    }
}
