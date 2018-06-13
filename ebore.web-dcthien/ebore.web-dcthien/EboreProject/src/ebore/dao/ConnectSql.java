package ebore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;


public class ConnectSql {
	static String sql;
	public  static Connection connection = null;
	public Timestamp timestamp;
	static {
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String url = "jdbc:sqlserver://ban-hang-giua-ky.database.windows.net:1433;database=ban-hang;user=thuytran@ban-hang-giua-ky;password={Ttpthuy791997};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
//		String url = "jdbc:sqlserver://THUYTRAN:1189;" + "databaseName=Ebore;integratedSecurity=True";
//		String url = "jdbc:sqlserver://alienchat.database.windows.net:1433;database=ebore;user=alienbot@alienchat;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
		String url = "jdbc:sqlserver://ebore-giuaky-server.database.windows.net:1433;database=theebore;user=ebore@ebore-giuaky-server;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try {
		Class.forName(driver);
		connection = DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	public ConnectSql(){
//		super();
////		sql = "jdbc:sqlserver://nguyennhan.database.windows.net:1433;database=WebBanHang;user=nguyennhan;password=a123456B;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
//	sql = "jdbc:sqlserver://localhost:49487;"+ "databaseName=Ebore;integratedSecurity=True";
//
//	}
//	public static Connection connect() throws Exception{
//		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			Connection connect = DriverManager.getConnection(sql);
//			System.out.println("Ket noi thanh cong");
//			return connect;
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
//		return null;
//	}
	public  void excuteSql(String sql) throws Exception{
//		Connection connect =connect();
		Statement stmt =  connection.createStatement();
		stmt.executeUpdate(sql);
	}
	public ResultSet selectData(String sql) throws Exception{
		Statement stmt =  connection.createStatement();
		ResultSet rs=	stmt.executeQuery(sql);
		return rs;
	}
	public static void main(String[] args) throws Exception {
		ConnectSql connect = new ConnectSql();
		System.out.println(connect.connection);
		
		
		
	}
}
