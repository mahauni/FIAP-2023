package org.mahauni.controller;

import org.mahauni.dao.MedicalAppointDAO;
import org.mahauni.factory.DAOFactory;
import org.mahauni.model.MedicalAppoint;
import org.mahauni.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/exams")
public class ExamsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private MedicalAppointDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = DAOFactory.getMedicalAppointDAO();
    }

    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        List<MedicalAppoint> appoints = dao.listRequestAppointments(new User());
        request.setAttribute("exams", appoints);

        request.getRequestDispatcher("menu-medico.jsp").forward(request, response);
    }
}
