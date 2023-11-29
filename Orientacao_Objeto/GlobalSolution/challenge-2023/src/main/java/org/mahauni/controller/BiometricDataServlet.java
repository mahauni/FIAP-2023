package org.mahauni.controller;

import org.mahauni.dao.BiometricDataDAO;
import org.mahauni.dao.HealthTechDAO;
import org.mahauni.dao.MedicalAppointDAO;
import org.mahauni.dao.UserDAO;
import org.mahauni.factory.DAOFactory;
import org.mahauni.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/bio-data")
public class BiometricDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private BiometricDataDAO dao;
    private MedicalAppointDAO medicalAppointDAO;
    private HealthTechDAO techDAO;
    private UserDAO userDAO;
    private BiometricDataDAO biometricDataDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = DAOFactory.getBiometricDataDAO();
        medicalAppointDAO = DAOFactory.getMedicalAppointDAO();
        techDAO = DAOFactory.getHealthTechDAO();
        userDAO = DAOFactory.getUserDAO();
        biometricDataDAO = DAOFactory.getBiometricDataDAO();
    }

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "makeExam":
                makeExam(request, response);
                break;

            default:
                break;
        }
    }

    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        int idAppoint = Integer.parseInt(request.getParameter("id"));

        MedicalAppoint appoint = new MedicalAppoint();
        appoint.setId(idAppoint);

        List<BiometricData> bioData = biometricDataDAO.getAppointBioData(appoint);

        request.setAttribute("data", bioData);
        request.setAttribute("idAppoint", idAppoint);

        request.getRequestDispatcher("resultado-dado.jsp").forward(request, response);
    }

    private void makeExam(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            int idAppoint = Integer.parseInt(request.getParameter("id"));
            String exam1 = request.getParameter("exame1");
            String exam2 = request.getParameter("exame2");

            MedicalAppoint appoint = medicalAppointDAO.getAppointment(idAppoint);
            appoint.setPendency(Pendency.PENDENT_ANALIZE);

            medicalAppointDAO.updateAppointment(appoint);

            List<HealthTech> techs = techDAO.getTechByExamType(appoint.getType());

            Cookie[] cookies = request.getCookies();
            String email = null;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    email = cookie.getValue();
                    break;
                }
            }

            User patient = userDAO.getUserByEmail(email);

            BiometricData data = new BiometricData(appoint, techs.get(0), patient, exam1);
            BiometricData data2 = new BiometricData(appoint, techs.get(1), patient, exam2);

            dao.registerBioData(data);
            dao.registerBioData(data2);

            response.sendRedirect("menu.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error");
        }
    }
}
