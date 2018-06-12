package customer.controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.CustomerDAO;
import dao.DAOProduct;
import model.*;

/**
 * Servlet implementation class EditCustomer
 */
@WebServlet("/editCustomer")
public class EditCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerID = request.getParameter("customerID");
		System.out.println(customerID);
		User user = CustomerDAO.lookUp(customerID);
		System.out.println(user + " this product");
		request.setAttribute("user", user);
		getServletContext().getRequestDispatcher("/editCustomer.jsp").forward(request, response);
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===============");
		String customerID = request.getParameter("customerID");
		System.out.println(customerID);
		User user = CustomerDAO.lookUp(customerID);
		System.out.println(user + " this product");
//		request.setAttribute("product", product);
		String code = user.getCusId();
		String newID = request.getParameter("editCID");
		String newName = request.getParameter("editCN");
		String newAcc = request.getParameter("editCU");
		String newTel = request.getParameter("editCT");
		User newUser = new User(newID, newName, newAcc,newTel);
		System.out.println(newUser + " new Pro");
		CustomerDAO dao = new CustomerDAO();
		dao.edit(newUser, code);
		System.out.println(CustomerDAO.mapCustomer);
		getServletContext().getRequestDispatcher("/customer.jsp").forward(request, response);

	}

}
