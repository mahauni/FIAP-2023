package dao;

import model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    private Connection connection;

    public PersonDAO(Connection connection) {
        this.connection = connection;
    }

    // make the telephone to be nullif
    public void insert(Person Person) {
        String sql = "INSERT INTO PERSONS(NAME_PERSON, EMAIL, TELEPHONE) VALUES(?, ?, NULLIF(?, null))";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, Person.getName());
            stmt.setString(2, Person.getEmail());
            stmt.setString(3, Person.getTelephone());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM PERSONS WHERE ID_PERSON=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Person Person) {
        String sql = "UPDATE PERSONS SET NAME_PERSON=?, EMAIL=?, TELEPHONE=NULLIF(?, null) WHERE ID_PERSON=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, Person.getName());
            stmt.setString(2, Person.getEmail());
            stmt.setString(3, Person.getTelephone());
            stmt.setInt(4, Person.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Person> selectAll() {
        List<Person> People = new ArrayList<>();
        String sql = "SELECT * FROM PERSONS";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Person Person = new Person();
                Person.setId(rs.getInt("ID_PERSON"));
                Person.setName(rs.getString("NAME_PERSON"));
                Person.setEmail(rs.getString("EMAIL"));
                Person.setTelephone(rs.getString("TELEPHONE"));


                People.add(Person);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return People;
    }

    public Person selectById(int id) {
        Person Person = null;
        String sql = "SELECT * FROM PERSONS WHERE ID_PERSON=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Person = new Person();
                Person.setId(rs.getInt("ID_PERSON"));
                Person.setName(rs.getString("NAME_PERSON"));
                Person.setEmail(rs.getString("EMAIL"));
                Person.setTelephone(rs.getString("TELEPHONE"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Person;
    }
}
