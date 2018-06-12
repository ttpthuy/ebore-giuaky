package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOProduct;
import model.Product;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/addProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
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
		String id = request.getParameter("addPID");
		String name = request.getParameter("addPN");
		String price = request.getParameter("addPP");
		String producer = request.getParameter("addProducer");
		Product p = new Product(id,name,Double.parseDouble(price),producer,null);
		DAOProduct dao = new DAOProduct();
		dao.add(p);
		System.out.println(DAOProduct.mapProduct);
		getServletContext().getRequestDispatcher("/product.jsp").forward(request, response);
	}

}
