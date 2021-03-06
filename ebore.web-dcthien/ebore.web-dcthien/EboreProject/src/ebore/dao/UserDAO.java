package ebore.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import ebore.model.Order;
import ebore.model.User;

public class UserDAO extends DAO{
	public static Map<String, User> mapUser = getLoadDTBS();

	private static Map<String, User> getLoadDTBS() {
		Map<String, User> dsOrder = new HashMap<String, User>();
		try {
			ResultSet rs = new ConnectSql().selectData("Select * from [USER]");
			while (rs.next()) {
				String idUser = rs.getString(1);
				String username = rs.getString("USERNAME");
				String pass = rs.getString("HASHPASSWORD");
				dsOrder.put(username, new User(username, pass));
				
			}
		} catch (Exception e) {
			System.out.println("Error load list database:" + e.getMessage());
			e.printStackTrace();
			return null;
		}
		return dsOrder;

	}

	public static User lookUp(String id) {
		return mapUser.get(id);
	}
	public boolean delete(String id) {
		try {
			if (myConnection == null) {
				myConnection = connectionPool.borrowConnection();
				connection = myConnection.getConnection();
			}
			String sql = "DELETE FROM [USER] WHERE USERNAME = ?";
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
	public boolean login(String usr, String pass){
		for (int i = 0; i < mapUser.size(); i++) {
			if (mapUser.get(i).getUsername().trim().equalsIgnoreCase(usr.trim()) && mapUser.get(i).getPass().trim().equalsIgnoreCase(pass.trim())) {
				return true;
			}
		}
		return false;
	}
	public List<User> select() {
		ArrayList<User> usersList = new ArrayList<>();
		try {
			if (myConnection == null) {
				myConnection = connectionPool.borrowConnection();
				connection = myConnection.getConnection();
			}
			String sql = "SELECT * FROM [USER]";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User newUser = new User(resultSet.getString("IDUSER"), resultSet.getString("USERNAME"),
						resultSet.getString("[HASHPASSWORD]"));
				usersList.add(newUser);
			}
			return usersList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionPool.returnConnection(myConnection);
			myConnection = null;
		}
		return usersList;
	}
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
		System.out.println(userDAO.mapUser);
		for (int i = 0; i < userDAO.mapUser.size(); i++) {
			
		}
	}
}
