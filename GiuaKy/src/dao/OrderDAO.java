package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import model.Order;
import model.User;

public class OrderDAO extends ObjDAO {
	public static String a,b;
//	public static Map<String, Order> mapOrder = new HashMap<String, Order>();
	public static List<Order> mapOrder = new ArrayList<>();
	static {
		try {
			ResultSet rs = DatabaseConnection
					.select("SELECT  [MADATHANG],[CUSTOMERID],[PRODUCTID],[DATE],[SOLG] FROM [RECEIPT]");
			while (rs.next()) {
				String madathang = rs.getString(1);
				String makh = rs.getString(2);
				String masp = rs.getString(3);
				String date = rs.getString(4);
				String solg = rs.getString(5);
				Order order = new Order(madathang, makh, masp, date, Integer.parseInt(solg));
				System.out.println(order.getTotal());
				mapOrder.add(order);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void add(Object obj) {
		Order order = (Order) obj;
		mapOrder.add( order);
		try {
			PreparedStatement statement = DatabaseConnection.insert_update(
					"insert into  RECEIPT ([MADATHANG],[CUSTOMERID],[PRODUCTID],[DATE],[SOLG])" + "values(?,?,?,?,?)");
			statement.setString(1, order.getId());
			statement.setString(2, order.getCusid());
			statement.setString(3, order.getProid());
			statement.setString(4, order.getDate());
			statement.setInt(5, order.getQuantity());
			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	private void analise(String id) {
		StringTokenizer st = new StringTokenizer(id, "\t");
		a = st.nextToken();
		b = st.nextToken();
	}
	@Override
	public void edit(Object obj, String id) {
		Order newOrder = (Order) obj;
		System.out.println(newOrder);
		analise(id);
		try {
			PreparedStatement statement = DatabaseConnection
					.insert_update("update RECEIPT SET" + " MADATHANG = ? ," + " CUSTOMERID = ? ," + " PRODUCTID = ? ,"
							+ " DATE = ? ," + " SOLG = ? " + "WHERE MADATHANG = ? and PRODUCTID = ?");
			statement.setString(1, newOrder.getId());
			statement.setString(2, newOrder.getCusid());
			statement.setString(3, newOrder.getProid());
			statement.setString(4, newOrder.getDate());
			statement.setInt(5, newOrder.getQuantity());
			statement.setString(6, a);
			statement.setString(7, b);
			statement.executeUpdate();
			System.out.println("thanhcong");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void delete(Object obj) {
		Order o = (Order) obj;
		try {
			PreparedStatement ps = DatabaseConnection.insert_update("delete from RECEIPT where MADATHANG = ? AND PRODUCTID = ?" ) ;
			ps.setString(1, o.getId());
			ps.setString(2, o.getProid());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static Order lookUp(String id, String pID) {
		Order order = null;
		for (int i = 0; i < mapOrder.size(); i++) 
			if (mapOrder.get(i).getId().equals(id) && mapOrder.get(i).getProid().equals(pID)) {
				 order = mapOrder.get(i) ;
			}
				return order;
	}

	@Override
	public ArrayList<Object> show() {
		return null;
	}

	public static void main(String[] args) {
	System.out.println(OrderDAO.mapOrder);
	System.out.println(OrderDAO.lookUp("02", "004"));
//	OrderDAO dao = new OrderDAO();
////	dao.add(new Order("03", "003", "003", null, 1));
////	dao.edit(new Order("03", "003", "003", null, 2), "03");
//	dao.delete(new Order("03", "003", "003", null, 2));
//	System.out.println("===");
//	System.out.println(OrderDAO.mapOrder);
}
}
