package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.Product;

public class DAOProduct extends ObjDAO {
	public static Map<String, Product> mapProduct = new HashMap<String, Product>();
	public static ArrayList<Product> products = new ArrayList<>();
	static{
		try{
			ResultSet rs = DatabaseConnection.select("select PRODUCTID, PRODUCTNAME, PRICE, PRODUCERID from"
															+ " PRODUCT ");
			while (rs.next()) {
				String productID = rs.getString(1);
				String productName = rs.getString(2);
				double productPrice = Double.parseDouble(rs.getString(3));
				String producerID = rs.getString(4);
				mapProduct.put(productID, new Product(productID,productName,productPrice,producerID,null));
				products.add(new Product(productID,productName,productPrice,producerID,null));
			}
	}catch (Exception e){
		System.out.println(e.getMessage());
	}
	}		
	@Override
	public void add(Object obj) {
		Product product = (Product) obj;
		mapProduct.put(product.getProductCode(), product);
		try{
		PreparedStatement statement = 	DatabaseConnection.insert_update("insert into  PRODUCT(productId, productName, productPrice, producerID, image)"
					+ "values(?,?,?,  ?,?)");
		statement.setString(1, product.getProductCode());
		statement.setString(2, product.getProductName());
		statement.setDouble(3, product.getProductPrice());
		statement.setString(4, product.getProducerID());
		statement.setString(5, null);
		statement.executeUpdate();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	@Override
	public void edit(Object obj,String id) {
		Product product = lookUp(id);
		Product newProduct = (Product) obj;
		System.out.println(product + "editPro");
		try{
			PreparedStatement statement = 	DatabaseConnection.insert_update("update PRODUCT SET"
					+ " PRODUCTID = ? ,"
					+ " PRODUCTNAME = ? ,"
					+ " PRICE = ? ,"
					+ " PRODUCERID = ? "
					+ "WHERE PRODUCTID = ?" );
			statement.setString(1, newProduct.getProductCode());
			statement.setString(2, newProduct.getProductName());
			statement.setDouble(3, newProduct.getProductPrice());
			statement.setString(4, newProduct.getProducerID());
			statement.setString(5, id);
//			statement.setString(1, "009");
//			statement.setString(2, "abc");
//			statement.setDouble(3, 90);
//			statement.setString(4, product.getProducerID());
//			statement.setString(5, id);
			statement.executeUpdate();
			System.out.println("thanhcong");
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		
	}

	@Override
	public  void delete(Object obj) {
		Product p = (Product) obj;
		try{
			PreparedStatement ps = DatabaseConnection.insert_update("delete from PRODUCT where PRODUCTID = ? " );
				ps.setString(1, p.getProductCode());
				ps.executeUpdate();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public static Product lookUp(String productcode){
		return mapProduct.get(productcode);
	}
	@Override
	public ArrayList<Object> show() {
		ArrayList<Object> list = (ArrayList<Object>) mapProduct;
		return list;
	}
	public static ArrayList<String> getProducer() {
		ArrayList<String> list = new ArrayList<>();
		try{
			ResultSet rs = DatabaseConnection.select("select PRODUCERID from PRODUCER");
			while (rs.next()) {
				String s1 = rs.getString(1);
				list.add(s1);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return list;
	}
	public static ArrayList<String> getProductID() {
		ArrayList<String> list = new ArrayList<>();
		try{
			ResultSet rs = DatabaseConnection.select("select PRODUCTID from PRODUCT");
			while (rs.next()) {
				String s1 = rs.getString(1);
				list.add(s1);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return list;
	}
	public static void main(String[] args) {
//		DAOProduct.editProduct(null, "001");
//		DAOProduct dao = new DAOProduct();
//		Collection list = DAOProduct.mapProduct.values();
//		Iterator<Product> itr = list.iterator();
//		while (itr.hasNext()) {
//			Product p = itr.next();
//			System.out.println(p.getProductCode() + " code");
//			System.out.println(p.getProductName() + " name");
//			System.out.println(p.getProductPrice() + " price");
//			System.out.println(p.getProducerID() + " producer");
//			System.out.println("=====");
//		}
//		dao.edit("005");
//		System.out.println("=======");
//		System.out.println(DAOProduct.mapProduct);
		System.out.println(DAOProduct.getProducer());
//		System.out.println(lookUp("001"));
	}
}
