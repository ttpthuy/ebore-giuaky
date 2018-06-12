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
 * Servlet implementation class EditOrder
 */
@WebServlet("/editOrder")
public class EditOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderID = request.getParameter("orderID");
		System.out.println(orderID + " doget method");
		String OPID = request.getParameter("orderPID");
		Order order = OrderDAO.lookUp(orderID,OPID);
		System.out.println(order + " this order get method");
		request.setAttribute("order", order);
		getServletContext().getRequestDispatcher("/editOrder.jsp").forward(request, response);
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===============");
		String orderID = request.getParameter("orderID");
		System.out.println(orderID + " post method");
		String OPID = request.getParameter("orderPID");
		System.out.println(OPID + " post method");
		System.out.println(OrderDAO.mapOrder);
		Order order = OrderDAO.lookUp(orderID,OPID);
		System.out.println(order + " this order");
//		request.setAttribute("product", product);
		String code = order.getId() + "\t" + OPID;
		String newOrId = request.getParameter("editOID");
		String newOrCuId = request.getParameter("editOCID");
		String newOrProId = request.getParameter("editOPID");
		String newOrQuantity = request.getParameter("editOQ");
		String newOD = request.getParameter("editOD");
//		order.setId(newOrId);
//		order.setCusid(newOrCuId);
//		order.setProid(newOrProId);
//		order.setQuantity(Integer.parseInt(newOrQuantity));
//		order.setDate(newOD);
		Order newOrder = new Order(newOrId, newOrCuId, newOrProId, newOD, Integer.parseInt(newOrQuantity));
		order.setId(newOrder.getId());
		order.setCusid(newOrder.getCusid());
		order.setProid(newOrder.getProid());
		order.setDate(newOrder.getDate());
		order.setQuantity(newOrder.getQuantity());
		System.out.println(newOrder + " new Ord");
		System.out.println(order + " order vua dc set");
		OrderDAO dao = new OrderDAO();
		dao.edit(newOrder, code);
		getServletContext().getRequestDispatcher("/bills.jsp").forward(request, response);

	}

}
