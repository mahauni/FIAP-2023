package controller;

import dao.PersonDAO;
import factory.ConnectionFactory;
import model.Person;

import java.sql.Connection;
import java.util.List;

public class PersonController {
    private final PersonDAO personDAO;

    public PersonController() {
        Connection connection = new ConnectionFactory().connection();
        this.personDAO = new PersonDAO(connection);
    }

    public void writeOnDb(Person person) {
        this.personDAO.insert(person);
    }

    public List<Person> listAll() {
        return this.personDAO.selectAll();
    }

    public List<Person> listPerEsg() {
        return null;
    }

    public List<Person> listPerProblem() {
        return null;
    }

    public void change(int id, String email, String telefone, String alias) {
        this.personDAO.update(new Person(id, email, telefone, alias));
    }

    public void delete(int id) {
        this.personDAO.delete(id);
    }
}
