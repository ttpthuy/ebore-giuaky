package ebore.model;

public class User {
	private String username;
	private String password;
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
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
	public boolean login(String name, String pass) {
		return username.equalsIgnoreCase(name) && password.equalsIgnoreCase(pass);
	}
}
