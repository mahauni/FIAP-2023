package org.mahauni.controller;

import java.io.IOException;

import org.mahauni.dao.UserDAO;
import org.mahauni.factory.DAOFactory;
import org.mahauni.model.User;
import org.mahauni.model.UserType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserDAO dao;

    public LoginServlet() {
        dao = DAOFactory.getUserDAO();
    }

    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(email, password);

        if (dao.validateUser(user)) {
            user = dao.getUserByEmail(email);
            HttpSession session = request.getSession();
            session.setAttribute("user", email);
            Cookie loginCookie = new Cookie("user", email);
            loginCookie.setMaxAge(60 * 60 * 24 * 365 * 10); // 10 years
            response.addCookie(loginCookie);
            if (user.getType() == UserType.MEDIC) {
                response.sendRedirect("menu-medico.jsp");
            } else {
                response.sendRedirect("menu.jsp");
            }
        } else {
            request.setAttribute("error", "User or password invalid");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
//        request.getRequestDispatcher("menu.jsp").forward(request, response);
    }

    protected void doGet(
        HttpServletRequest request, 
        HttpServletResponse response
    ) throws IOException, ServletException {
        HttpSession session = request.getSession();
        session.invalidate();
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
