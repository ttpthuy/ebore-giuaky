package ebore.model;

import ebore.dao.OrderDAO;
import ebore.dao.UserDAO;

public class User {
	static String idUser;
	static String username;
	static String password;
	private static UserDAO userDAO;
	public User (String username, String pass){
		this.username = username;
		this.password = pass;
	}
	public User(String id, String username, String password) {
		super();
		this.idUser = id;
		this.username = username;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public static String getIdUser() {
		return idUser;
	}
	public static void setIdUser(String idUser) {
		User.idUser = idUser;
	}
	@Override
	public String toString() {
		return username + "  " +  password + " \n";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return password;
	}
	public void setPass(String pass) {
		this.password = pass;
	}
	public boolean equalName(String name) {
		return username.equalsIgnoreCase(name);
	}
	public static boolean login(String name, String pass) {
		return userDAO.login(name, pass);
	}
	public static void deleteUser(String id) {
		userDAO = (userDAO == null) ? new UserDAO() : userDAO;
		userDAO.delete(id);
	}
	
//	public static boolean login(String usr, String pass){
//		return true;
//	}
}
