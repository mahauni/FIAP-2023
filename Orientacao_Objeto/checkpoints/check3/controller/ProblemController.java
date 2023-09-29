package controller;

import dao.ProblemDAO;
import factory.ConnectionFactory;
import model.Esg;
import model.Problem;

import java.sql.Connection;
import java.util.List;

public class ProblemController {
    private final ProblemDAO problemDAO;

    public ProblemController() {
        Connection connection = new ConnectionFactory().connection();
        this.problemDAO = new ProblemDAO(connection);
    }

    public void writeOnDb(Problem problem) {
        this.problemDAO.insert(problem);
    }

    public List<Problem> listAll() {
        return this.problemDAO.selectAll();
    }

    public List<Esg> listPerEsg() {
        return null;
    }

    public List<Problem> listPerPerson() {
        return null;
    }

    public void change(int id, String description, int completed, int idPerson, int idEsg) {
        this.problemDAO.update(new Problem(id, description, completed, idPerson, idEsg));
    }

    public void delete(int id) {
        this.problemDAO.delete(id);
    }
}
