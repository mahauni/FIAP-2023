package org.mahauni.controller;

import org.mahauni.dao.HealthTechDAO;
import org.mahauni.dao.UserDAO;
import org.mahauni.factory.DAOFactory;
import org.mahauni.model.HealthTech;
import org.mahauni.model.User;
import org.mahauni.model.UserType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserDAO userDao;
    private HealthTechDAO techDao;

    @Override
    public void init() throws ServletException {
        super.init();
        userDao = DAOFactory.getUserDAO();
        techDao = DAOFactory.getHealthTechDAO();
    }

    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "registerUser":
                registerUser(request, response);
                break;

            case "requestTech":
                requestTech(request, response);
                break;

            default:
                break;
        }
    }

    private void registerUser(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String type = request.getParameter("role");

            User user = new User(name, email, password, UserType.valueOf(type));

            userDao.createUser(user);

            request.setAttribute("msg", "User registered");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error");
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    // TODO fazer um jeito para ele requisitar a tech
    private void requestTech(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");

            HealthTech tech = techDao.getTechByName(name);

            techDao.requestTech(tech);

            request.setAttribute("msg", "Appointment registered");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error");
        }
    }
}
