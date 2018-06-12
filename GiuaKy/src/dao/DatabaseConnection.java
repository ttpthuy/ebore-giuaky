package dao;

import java.sql.*;

public class DatabaseConnection {
	public static Connection connection = null;
	static {
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://ban-hang-giua-ky.database.windows.net:1433;database=ban-hang;user=thuytran@ban-hang-giua-ky;password={Ttpthuy791997};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
//		String url = "jdbc:sqlserver://THUYTRAN:1189;" + "databaseName=WEB_GIUAKY;integratedSecurity=True";
		try {
		Class.forName(driver);
		connection = DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection(){
//		Connection connection = null;
//		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		try {
//		Class.forName(driver);
//		connection = DriverManager.getConnection(url);
//		return connection;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return connection;
		
	}
	public static PreparedStatement insert_update(String sql) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(sql);
//		Statement st = connection.createStatement();
//		ps.executeUpdate(sql);
		return ps;
	}
	public static ResultSet select(String sql) throws SQLException {
//		PreparedStatement ps = connection.prepareStatement(sql);
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}
	
	
	
	public static void main(String[] args) throws SQLException {
		 // Create a variable for the connection string.  
//	      String connectionUrl = "jdbc:sqlserver://THUYTRAN:1189;" +  
//	         "databaseName=DW_TS_LAB1;integratedSecurity=True";  
//
//	      // Declare the JDBC objects.  
//	      Connection con = null;  
//	      Statement stmt = null;  
//	      ResultSet rs = null;  
//
//	      try {  
//	         // Establish the connection.  
//	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
//	         con = DriverManager.getConnection(connectionUrl);  
//
//	         // Create and execute an SQL statement that returns some data.  
//	         String SQL = "SELECT TOP 10 * FROM dim_KHOI";  
//	         stmt = con.createStatement();  
//	         rs = stmt.executeQuery(SQL);  
//
//	         // Iterate through the data in the result set and display it.  
//	         while (rs.next()) {  
//	            System.out.println(rs.getString(1) );  
//	         }  
//	      }  
//
//	      // Handle any errors that may have occurred.  
//	      catch (Exception e) {  
//	         e.printStackTrace();  
//	      }  
//	      finally {  
//	         if (rs != null) try { rs.close(); } catch(Exception e) {}  
//	         if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
//	         if (con != null) try { con.close(); } catch(Exception e) {}  
//	      } 
		
//		ResultSet rs = DatabaseConnection.select("select productID, productName, price, producerID from PRODUCT where productID = ?");
//		while (rs.next()) {
//			System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getString(4)
//			+ " | " + rs.getString(5) );
//		}
		DatabaseConnection.insert_update("INSERT INTO  PRODUCT(productId, productName, Price, producerID, image)"
					+ "values(,?,?,?,?)");

		
		
	}
	
}
