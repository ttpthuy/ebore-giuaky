package order.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOProduct;
import dao.OrderDAO;
import model.Order;
import model.Product;

/**
 * Servlet implementation class DeleteOrder
 */
@WebServlet("/deleteOrder")
public class DeleteOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOrder() {
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
		String orderID = request.getParameter("orderID");
		String orderPID = request.getParameter("orderPID");
		System.out.println(orderPID);
		Order o = OrderDAO.lookUp(orderID,orderPID);
		System.out.println(o);
		OrderDAO dao = new OrderDAO();
		dao.delete(o);
		OrderDAO.mapOrder.remove(o);
		getServletContext().getRequestDispatcher("/bills.jsp").forward(request, response);		
	}

}
