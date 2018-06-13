package ebore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;


public class MyConnection {
//	private static String hostURL = "jdbc:sqlserver://localhost:49487;databaseName=Ebore";
//	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	String url = "jdbc:sqlserver://ban-hang-giua-ky.database.windows.net:1433;database=ban-hang;user=thuytran@ban-hang-giua-ky;password={Ttpthuy791997};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
//	String url = "jdbc:sqlserver://THUYTRAN:1189;" + "databaseName=Ebore;integratedSecurity=True";
//	private static String user = "sa";
//	private static String pass = "sa";
	
//	String connectionUrl = "jdbc:sqlserver://localhost:49487;"
//			+ "databaseName=Ebore ;integratedSecurity=True";
	
	public  static Connection connection = null;
	public Timestamp timestamp;
	static {
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String url = "jdbc:sqlserver://ban-hang-giua-ky.database.windows.net:1433;database=ban-hang;user=thuytran@ban-hang-giua-ky;password={Ttpthuy791997};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		String url = "jdbc:sqlserver://THUYTRAN:1189;" + "databaseName=Ebore;integratedSecurity=True";
		try {
		Class.forName(driver);
		connection = DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public MyConnection() {
//		connection = connect();
//	}
	
	
	public static Connection getConnection() {
		return connection;
	}

//	public static void setConnection(Connection connection) {
//		this.connection = connection;
//	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

//	private Connection connect() {
//		try {
//			Class.forName(driver);
//			connection = DriverManager.getConnection(driver);
//			return connection;
//		} catch( SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		return connection;
//	}
	
}
