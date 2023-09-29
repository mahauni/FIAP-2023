package controller;

import dao.EsgDAO;
import factory.ConnectionFactory;
import model.Esg;
import model.enumEsg;

import java.sql.Connection;
import java.util.List;

public class EsgController {
    private final EsgDAO esgDAO;

    public EsgController() {
        Connection connection = new ConnectionFactory().connection();
        this.esgDAO = new EsgDAO(connection);
    }

    public void writeOnDb(Esg esg) {
        this.esgDAO.insert(esg);
    }

    public List<Esg> listAll() {
        return this.esgDAO.selectAll();
    }

    public List<Esg> listPerPerson() {
        return null;
    }

    public List<Esg> listPerProblem() {
        return null;
    }

    public void change(int id, enumEsg esg, String desc) {
        this.esgDAO.update(new Esg(id, esg, desc));
    }

    public void delete(int id) {
        this.esgDAO.delete(id);
    }
}
