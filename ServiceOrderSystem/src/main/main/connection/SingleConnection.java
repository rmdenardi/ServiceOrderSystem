package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection {
	private static String database = "jdbc:postgresql://localhost:5432/serviceorder?autoReconnect=true";
	private static String user ="postgres";
	private static String password ="w190pkk17";
	private static Connection connection;
	
	
	public static Connection getConnection() {
		return connection;
	}
	
	static {
		try {
			conectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/*
	 *Method which connects on the database
	 */
	private static void conectar() throws SQLException {
		try {
		if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection=DriverManager.getConnection(database, user, password);
				connection.setAutoCommit(false);
			} 
		
		}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}


}
