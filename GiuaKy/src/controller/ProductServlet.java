package controller;


import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import dao.*;


/**
 * Servlet implementation class RemoveItem
 */
@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
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
		String action = request.getParameter("action");
		System.out.println(action + " action");
		switch (action) {
		case "add":
			
			break;
		case "edit":
			String productcode2 = request.getParameter("productCode");
			System.out.println(productcode2);
			Product product = DAOProduct.lookUp(productcode2);
			System.out.println("=======");
			System.out.println(product + " product");
			request.setAttribute("productEdit", product);
			String newID = request.getParameter("editPID");
			String newName = request.getParameter("editPN");
			String newPrice = request.getParameter("editPP");
			String newProducer = request.getParameter("editProducer");
			getServletContext().getRequestDispatcher("/product.jsp").forward(request, response);
			product.setProductCode(newID);
			product.setProductName(newName);
			product.setProductPrice(Double.parseDouble(newPrice));
			product.setProducerID(newProducer);
//			Product product2 = new Product(newID,newName,Double.parseDouble(newPrice),newProducer,null);
			DAOProduct dao = new DAOProduct();
			dao.edit(product, productcode2);
			response.sendRedirect("product.jsp");
			break;
		case "edit2":
			Product pro = (Product) request.getAttribute("productEdit");
			break;
		case "delete":
			String productcode3 = request.getParameter("productCode");
			delete(productcode3);
			
			break;
		case "deleteAll":
			deleteAll();
			
			break;

		default:
			break;
		}
		
		
		
		
//		HttpSession session = request.getSession();
//		Cart cart = (Cart) session.getAttribute("cart");
//		if (cart == null) {
//			cart = new Cart();
//			session.setAttribute("cart", cart);
//		}
//		String productCode = request.getParameter("productCode");
//		LineItem item = cart.lookUp(productCode);
//		if (item != null) {
//			cart.removeItem(item);
//		}
//		session.setAttribute("cart", cart);
//		getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);
	}

	private void deleteAll() {
		// TODO Auto-generated method stub
		
		
	}

	private void delete(String productcode3) {
		// TODO Auto-generated method stub
		
	}

	private void edit(String productcode) {
		// TODO Auto-generated method stub
		
	}

	private void add() {
		
	}
}
