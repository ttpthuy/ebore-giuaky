package ebore.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ebore.model.Order;

public class OrderDAO extends DAO {
	public static Map<String, Order> mapOrder = getLoadDTBS();

	private static Map<String, Order> getLoadDTBS() {

		Map<String, Order> dsOrder = new HashMap<String, Order>();
		try {
			ResultSet rs = new ConnectSql().selectData("Select * from [ORDER]");
			while (rs.next()) {
				String idOrder = rs.getString(1);
				String idStory = rs.getString(2);
				String idUser = rs.getString(3);
				Date date = rs.getDate(4);
				dsOrder.put(idOrder, new Order(idOrder, idStory, idUser, date));
			}
		} catch (Exception e) {
			System.out.println("Error load list database:" + e.getMessage());
			e.printStackTrace();
			return null;
		}
		return dsOrder;

	}

	

	public boolean delete(String id) {
		try {
			if (myConnection == null) {
				myConnection = connectionPool.borrowConnection();
				connection = myConnection.getConnection();
			}
			String sql = "DELETE FROM [ORDER] WHERE IDORDER = ?";
			System.out.println("==========================================================S");
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setObject(1, id);
			statement.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			connectionPool.returnConnection(myConnection);
			myConnection = null;

		}
	}

	public List<Order> selectAllOrder() {
		ArrayList<Order> ordersList = new ArrayList<>();
		try {
			if (myConnection == null) {
				myConnection = connectionPool.borrowConnection();
				connection = myConnection.getConnection();
			}
			String sql = "SELECT * FROM [ORDER]";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Order newOrder = new Order(resultSet.getString("IDORDER"), resultSet.getString("IDSTORY"),
						resultSet.getString("IDUSER"), resultSet.getDate("DATE"));
				ordersList.add(newOrder);
			}
			return ordersList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionPool.returnConnection(myConnection);
			myConnection = null;
		}
		return ordersList;
	}
	public static void main(String[] args) {
		OrderDAO orderDAO = new OrderDAO();
		System.out.println(orderDAO.mapOrder);
	}
}
