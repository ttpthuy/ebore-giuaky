package ebore.dao;

import java.sql.Connection;

public class DAO {
	protected static ConnectionPool connectionPool = new ConnectionPool(5, 10, 180);
	protected MyConnection myConnection;
	protected Connection connection;
}
