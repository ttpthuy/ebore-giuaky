package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOProduct;
import dao.DatabaseConnection;
import model.Product;

/**
 * Servlet implementation class EditProduct
 */
@WebServlet("/editProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productCode = request.getParameter("productCode");
		System.out.println(productCode);
		Product product = DAOProduct.lookUp(productCode);
		System.out.println(product + " this product");
		request.setAttribute("product", product);
		getServletContext().getRequestDispatcher("/editProduct.jsp").forward(request, response);
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===============");
		String productCode = request.getParameter("productCode");
		System.out.println(productCode);
		Product product = DAOProduct.lookUp(productCode);
		System.out.println(product + " this product");
//		request.setAttribute("product", product);
		String code = product.getProductCode();
		String newID = request.getParameter("editPID");
		String newName = request.getParameter("editPN");
		String newPrice = request.getParameter("editPP");
		String newProducer = request.getParameter("editProducer");
		product.setProductCode(newID);
		product.setProductName(newName);
		product.setProductPrice(Double.parseDouble(newPrice));
		product.setProducerID(newProducer);
		Product newProduct = new Product(newID, newName, Double.parseDouble(newPrice),newProducer,null);
		System.out.println(newProduct + " new Pro");
		DAOProduct dao = new DAOProduct();
		dao.edit(newProduct, code);
		System.out.println(DAOProduct.mapProduct);
		System.out.println(DAOProduct.products);
		getServletContext().getRequestDispatcher("/product.jsp").forward(request, response);
	}

}
