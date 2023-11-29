package org.mahauni.controller;

import org.mahauni.dao.HealthTechDAO;
import org.mahauni.dao.RatingDAO;
import org.mahauni.dao.UserDAO;
import org.mahauni.factory.DAOFactory;
import org.mahauni.model.HealthTech;
import org.mahauni.model.MedicalAppoint;
import org.mahauni.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tech")
public class TechServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private HealthTechDAO techDAO;

    public TechServlet() {
        techDAO = DAOFactory.getHealthTechDAO();
    }

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        List<HealthTech> techs = techDAO.getTech();
        request.setAttribute("techs", techs);
        // rever isso depois
        request.getRequestDispatcher("tecnologias.jsp").forward(request, response);
    }
}
