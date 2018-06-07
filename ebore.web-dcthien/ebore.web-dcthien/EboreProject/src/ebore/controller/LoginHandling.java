package ebore.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ebore.dao.UserDAO;
import ebore.model.User;

/**
 * Servlet implementation class LoginHandling
 */
@WebServlet("/LoginHandling")
public class LoginHandling extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginHandling() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		if	(name == null) {
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			response.sendRedirect("LoginSuccess");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String errorMessage = null;
		
		System.out.println(username + " " + password);
		
		if ((username == null || username.equals("")) && (password == null || password.equals(""))) {
			errorMessage = "You haven't entered your username and password";
		} else if (username == null || username.equals("")) {
			errorMessage = "You haven't entered your username";
		} else if (password == null || password.equals("")) {
			errorMessage = "You haven't entered your password";
		} else {
			errorMessage = "Please check your username and password";
		}
		System.out.println(errorMessage);
		request.setAttribute("errorMessage", errorMessage);
		
		User user = new User();
		try {
			if (UserDAO.login(username, password) == true) {
				user.setUsername(username);
				user.setPass(password);
				System.out.println(user.getUsername() + " " + user.getPass());
				HttpSession session = request.getSession();
				session.setAttribute("name", username);
				response.sendRedirect("LoginSuccess");
			} else {
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("errorMessage", errorMessage);
		return;
		
		
	}

}
