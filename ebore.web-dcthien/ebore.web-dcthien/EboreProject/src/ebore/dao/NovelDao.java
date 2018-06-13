package ebore.dao;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ebore.model.Novel;
import sun.security.provider.NativePRNG;

/**
 *
 * @author DELL
 */
public class NovelDao extends DAO{
	public static Map<String, Novel> mapNovel = new HashMap<String, Novel>();
	static {
		try {
//			DatabaseConnection connection = new DatabaseConnection();
			ResultSet rs = new ConnectSql().selectData("SELECT * FROM [STORY]");
			while (rs.next()) {
				String novID = rs.getString(1);
				String novName = rs.getString(2);
				double novPrice = rs.getDouble(4);
				String novType = rs.getString(3);
				String novAuthor = rs.getString(6);
				String novLanguage = rs.getString(7);
				int novLuotXem = rs.getInt(5);
				mapNovel.put(novID, new Novel(novID,novName,novPrice,novType,novAuthor, novLanguage,novType,novAuthor));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean delete(String id) {
		try {
			if (myConnection == null) {
				myConnection = connectionPool.borrowConnection();
				connection = myConnection.getConnection();
			}
			String sql = "DELETE FROM [STORY] WHERE IDSTORY = ?";
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

	public static Novel lookUp(String id) {
		return mapNovel.get(id);
	}

	public ArrayList<Object> show() {
		ArrayList<Object> list = (ArrayList<Object>) mapNovel;
		return list;
	}
	public static ArrayList<String> getCustomerID() throws Exception {
		ArrayList<String> list = new ArrayList<>();
		try {
//			DatabaseConnection connect = new DatabaseConnection();
			ResultSet rs = new ConnectSql().selectData("select IDSTORY from STORY");
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
	

	public List<Novel> selectAllNovel() {
		ArrayList<Novel> novelList = new ArrayList<>();
		try {
			if (myConnection == null) {
				myConnection = connectionPool.borrowConnection();
				connection = myConnection.getConnection();
			}
			String sql = "SELECT * FROM [STORY]";
			System.out.println(".....................................................");
			PreparedStatement statement = connection.prepareStatement(sql);
			System.out.println(".....................****************************..........");

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				Novel newNovel = new Novel(rs.getString("IDSTORY"), rs.getString("TITLE"), rs.getDouble("PRICE"), rs.getString("TYPE"), rs.getString("IDUSER"), rs.getString("LANGUAGE"), rs.getString("DESCRIPTION"), rs.getString("SCONTENT") );
				novelList.add(newNovel);
			} 
			/**
			
			*/
			return novelList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionPool.returnConnection(myConnection);
			myConnection = null;
		}
		return novelList;
	}
	public static void main(String[] args) {
//		System.out.println(CustomerDAO.mapCustomer);
		NovelDao dao = new NovelDao();
//		dao.add(new User("004", "Tran Thi Hat Xi", "user004", "4444", null));
//		System.out.println(CustomerDAO.mapCustomer);
		Novel newNovel = new Novel("ss1", "Samsung Ä‘en", 6990000, "tieu thuyet", "A", "Tiáº¿ng viá»‡t", "acb", "abc");
//		dao.delete(newUser);
		System.out.println(NovelDao.mapNovel);
	}

//	static List<Novel> list = new ArrayList<>();
//
//	static {
//		list.add(new Novel("ss1", "Samsung Ä‘en", 6990000, "tieu thuyet", "A", "Tiáº¿ng viá»‡t", "acb", "abc"));
//		list.add(new Novel("ip6", "Iphone 6s new 99%", 8900000, "tieu thuyet", "B", "Tiáº¿ng anh", "abc", "abc"));
//		list.add(new Novel("mbs", "Mobistar", 8900000, "tieu thuyet", "C", "Tiáº¿ng viá»‡t", "abc", "abc"));
//		list.add(new Novel("nka", "Nokia", 3500000, "tieu thuyet", "A", "Tiáº¿ng viá»‡t", "abc", "abc"));
//		list.add(new Novel("obi", "Obi", 4900000, "tieu thuyet", "D", "Tiáº¿ng anh", "abc", "abc"));
//		list.add(new Novel("ss2", "Samsung tráº¯ng", 8900000, "tieu thuyet", "E", "Tiáº¿ng viá»‡t", "abc", "abc"));
//		list.add(new Novel("ss3", "Sam sung full viá»�n", 6900000, "tieu thuyet", "B", "Tiáº¿ng viá»‡t", "abc", "abc"));
//		list.add(new Novel("vv", "ViVo", 7900000, "tieu thuyet", "B", "Tiáº¿ng anh", "abc", "abc"));
//	}
//
//	public static List<Novel> getList() {
//		return list;
//	}
//
//	public static Novel getPro(String proCode) {
//		for (Novel product : list) {
//			if (product.getMe(proCode)) {
//				return product;
//			}
//		}
//		return null;
//	}
//
//	public static void removeItem(String novelCode) {
//		for (Novel novel : list) {
//			if (novel.equalNovelCode(novelCode)) {
//				list.remove(novel);
//				return;
//			}
//		}
//	}
}
