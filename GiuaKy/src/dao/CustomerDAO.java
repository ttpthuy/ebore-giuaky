package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.Product;
import model.User;

public class CustomerDAO extends ObjDAO {
	public static Map<String, User> mapCustomer = new HashMap<String, User>();
	static {
		try {
			ResultSet rs = DatabaseConnection
					.select("SELECT [MAKHACHHANG],[TENKHACHHANG],[TAIKHOAN],[MATKHAU],[SODIENTHOAI] FROM [KHACHHANG]");
			while (rs.next()) {
				String cusID = rs.getString(1);
				String cusName = rs.getString(2);
				String cusAcc = rs.getString(3);
				String cusPass = rs.getString(4);
				String cusTel = rs.getString(5);
				mapCustomer.put(cusID, new User(cusID,cusName,cusAcc,cusPass,cusTel));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void add(Object obj) {
		User user = (User) obj;
		mapCustomer.put(user.getCusId(), user);
		try {
			PreparedStatement statement = DatabaseConnection
					.insert_update("insert into  KHACHHANG ([MAKHACHHANG],[TENKHACHHANG],[TAIKHOAN],[MATKHAU],[SODIENTHOAI])"
							+ "values(?,?,?,?,?)");
			statement.setString(1, user.getCusId());
			statement.setString(2, user.getCusName());
			statement.setString(3, user.getCusAcc());
			statement.setString(4, user.getCusPass());
			statement.setString(5, user.getCusTel());
			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void edit(Object obj, String id) {
		User newUser = (User) obj;
		System.out.println(newUser);
		try {
			PreparedStatement statement = DatabaseConnection.insert_update("update KHACHHANG SET"  
						+	" MAKHACHHANG = ? ,"
					    + " TENKHACHHANG = ? ," 
						+ " TAIKHOAN = ? ,"
					    + " MATKHAU = ? ," 
						+ " SODIENTHOAI = ? " 
					    + "WHERE MAKHACHHANG = ?");
			statement.setString(1, newUser.getCusId());
			statement.setString(2, newUser.getCusName());
			statement.setString(3, newUser.getCusAcc());
			statement.setString(4, newUser.getCusPass());
			statement.setString(5, newUser.getCusTel());
			statement.setString(6, id);
			statement.executeUpdate();
			System.out.println("thanhcong");
			System.out.println(mapCustomer);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void delete(Object obj) {
		User u = (User) obj;
		try {
			PreparedStatement ps = DatabaseConnection.insert_update("delete from KHACHHANG where MAKHACHHANG = ? ");
			ps.setString(1, u.getCusId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static User lookUp(String id) {
		return mapCustomer.get(id);
	}

	@Override
	public ArrayList<Object> show() {
		ArrayList<Object> list = (ArrayList<Object>) mapCustomer;
		return list;
	}
	public static ArrayList<String> getCustomerID() {
		ArrayList<String> list = new ArrayList<>();
		ResultSet rs;
		try {
			rs = DatabaseConnection.select("select MAKHACHHANG from KHACHHANG");
			while (rs.next()) {
				String s1 = rs.getString(1);
				list.add(s1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
//		System.out.println(CustomerDAO.mapCustomer);
		CustomerDAO dao = new CustomerDAO();
//		dao.add(new User("004", "Tran Thi Hat Xi", "user004", "4444", null));
//		System.out.println(CustomerDAO.mapCustomer);
		User newUser = new User("004", "Tran Thi Hat Xi", "user004", "4445", null);
//		dao.delete(newUser);
		System.out.println(CustomerDAO.mapCustomer);
	}

}
