package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import repository.Database;

/**
 * Servlet implementation class newUserServlet
 */
@WebServlet("/newUser")
public class newUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newUserServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("formNewUser.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nameUser = request.getParameter("name");
		String emailUser = request.getParameter("email");
		String telephoneUser = request.getParameter("telephone");
		String passwdUser = request.getParameter("passwds");
		
		User user = new User(nameUser, emailUser, telephoneUser, passwdUser);
		
		Database.adiciona(user);
		
		request.setAttribute("user", user);
		response.sendRedirect("listUsers");
	}

}
