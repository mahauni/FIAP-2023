package org.mahauni.controller;

import org.mahauni.dao.HealthTechDAO;
import org.mahauni.dao.MedicalAppointDAO;
import org.mahauni.dao.RatingDAO;
import org.mahauni.dao.UserDAO;
import org.mahauni.factory.DAOFactory;
import org.mahauni.model.HealthTech;
import org.mahauni.model.MedicalAppoint;
import org.mahauni.model.Rating;
import org.mahauni.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/rating")
public class RatingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private RatingDAO ratingDao;
    private UserDAO userDAO;
    private HealthTechDAO techDAO;
    private MedicalAppointDAO appointDAO;

    public RatingServlet() {
        ratingDao = DAOFactory.getRatingDAO();
        userDAO = DAOFactory.getUserDAO();
        techDAO = DAOFactory.getHealthTechDAO();
        appointDAO = DAOFactory.getMedicalAppointDAO();
    }

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        int idAppoint = Integer.parseInt(request.getParameter("consulta"));
        MedicalAppoint medicalAppoint = appointDAO.getAppointment(idAppoint);
        int rating1 = Integer.parseInt(request.getParameter("notaMaquina0"));
        int rating2 = Integer.parseInt(request.getParameter("notaMaquina1"));

        Cookie[] cookies = request.getCookies();
        String email = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user")) {
                email = cookie.getValue();
                break;
            }
        }
        User patient = userDAO.getUserByEmail(email);

        List<HealthTech> techs = techDAO.getTechByExamType(medicalAppoint.getType());

        Rating rate1 = new Rating(patient, techs.get(0), rating1);

        Rating rate2 = new Rating(patient, techs.get(1), rating2);

        ratingDao.rateTech(rate1);
        ratingDao.rateTech(rate2);
        response.sendRedirect("menu.jsp");
    }

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String email = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user")) {
                email = cookie.getValue();
                break;
            }
        }
        User user = userDAO.getUserByEmail(email);
        List<MedicalAppoint> exams = appointDAO.listExamAppointmentsFinilized(user);

        request.setAttribute("exams", exams);

        request.getRequestDispatcher("avaliacao.jsp").forward(request, response);
    }
}
