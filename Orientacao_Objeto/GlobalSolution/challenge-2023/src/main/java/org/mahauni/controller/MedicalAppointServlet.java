package org.mahauni.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.mahauni.dao.AppointResultDAO;
import org.mahauni.dao.ExamTypeDAO;
import org.mahauni.dao.MedicalAppointDAO;
import org.mahauni.dao.UserDAO;
import org.mahauni.factory.DAOFactory;
import org.mahauni.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/appointment")
public class MedicalAppointServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private MedicalAppointDAO dao;
    private ExamTypeDAO ExamTypeDao;
    private UserDAO userDAO;
    private AppointResultDAO resultDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = DAOFactory.getMedicalAppointDAO();
        ExamTypeDao = DAOFactory.getExamTypeDAO();
        userDAO = DAOFactory.getUserDAO();
        resultDAO = DAOFactory.getAppointResultDAO();
    }

    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "requestAppointment":
                requestAppointment(request, response);
                break;

            case "acceptAppointment":
                acceptAppointment(request, response);
                break;

            case "finalizeExam":
                finalizeExam(request, response);
                break;

            case "deleteAppointment":
                deleteAppointment(request, response);
                break;

            default:
                break;
        }
    }

    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "list":
                list(request, response);
                break;

            case "listExams":
                listExams(request, response);
                break;

            case "listAppointments":
                listAppointments(request, response);
                break;

            default:
                break;
        }
    }

    private void requestAppointment(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            Cookie[] cookies = request.getCookies();
            String email = null;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    email = cookie.getValue();
                    break;
                }
            }
            String name = request.getParameter("name");
            User patient = userDAO.getUserByEmail(email);
            ExamType type = ExamTypeDao.getExamType(request.getParameter("appointType"));
            Pendency pendency = Pendency.PENDENT_MEDIC;
            String appointTimeString = request.getParameter("appointTime");

            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = formatter.parse(appointTimeString);
            java.sql.Date appointTime = new java.sql.Date(utilDate.getTime());

            String message = request.getParameter("message");

            MedicalAppoint appoint = new MedicalAppoint(name, patient, type, pendency, appointTime, message);

            dao.registerAppointment(appoint);

            request.setAttribute("msg", "Appointment registered");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error");
        }
        response.sendRedirect("menu.jsp");
    }

    private void listExams(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MedicalAppoint> appoints = dao.listExamAppointments();
        request.setAttribute("exams", appoints);
        request.getRequestDispatcher("aceitar-consulta.jsp").forward(request, response);
    }

    private void acceptAppointment(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            int idAppoint = Integer.parseInt(request.getReader().lines().collect(Collectors.joining()));

            MedicalAppoint appoint = dao.getAppointment(idAppoint);
            appoint.setPendency(Pendency.PENDENT_DATA);

            dao.updateAppointment(appoint);

            request.setAttribute("msg", "Appointment registered");
            response.sendRedirect("menu-medico.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error");
        }
    }

    private void deleteAppointment(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            int idAppoint = Integer.parseInt(request.getReader().lines().collect(Collectors.joining()));

            dao.deleteAppoint(idAppoint);


        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error");
        }
    }

    private void finalizeExam(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        int idAppoint = Integer.parseInt(request.getParameter("id"));
        String message = request.getParameter("resultadoExame");

        MedicalAppoint appoint = dao.getAppointment(idAppoint);
        appoint.setPendency(Pendency.FINILIZED);
        dao.updateAppointment(appoint);

        AppointResult result = new AppointResult(appoint, message);

        resultDAO.createResult(result);
        request.getRequestDispatcher("menu-medico.jsp").forward(request, response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MedicalAppoint> appoints = dao.listRequestAppointments(new User());
        request.setAttribute("exams", appoints);
        request.getRequestDispatcher("exames.jsp").forward(request, response);
    }

    private void listAppointments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MedicalAppoint> appoints = dao.listRequestAppointments(new User());
        request.setAttribute("exams", appoints);
        request.getRequestDispatcher("gerenciamento.jsp").forward(request, response);
    }
}
