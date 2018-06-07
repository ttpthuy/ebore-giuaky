package ebore.dao;

import java.util.ArrayList;
import java.util.List;

import ebore.model.User;

public class UserDAO {
	static List<User> list = new ArrayList<User>();
	static {
		list.add(new User("admin", "1234"));
		list.add(new User("user", "4321"));
	}
	
	public static boolean checkUser(String usr) {
		for (User user : list) {
			if (user.equalName(usr)) return true;				
		}
		return false;
	}
	public static boolean login(String usr, String pss) {
		for (User user : list) {
			if (user.login(usr, pss)) return true;
		}
		return false;
	}
	
}
