package customer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import dao.DAOProduct;
import model.Product;
import model.User;

/**
 * Servlet implementation class AddCustomer
 */
@WebServlet("/addCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("addCID");
		String name = request.getParameter("addCN");
		String acc = request.getParameter("addCA");
		String pass = request.getParameter("addCPass");
		String sdt = request.getParameter("addCT");
		User u = new User(id, name, acc, pass, sdt);
		CustomerDAO dao = new CustomerDAO();
		dao.add(u);
		System.out.println(CustomerDAO.mapCustomer);
		getServletContext().getRequestDispatcher("/customer.jsp").forward(request, response);
	}

}
