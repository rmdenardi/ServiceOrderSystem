package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingleConnection;
import model.ModelLogin;

public class DAOLoginRepository {
	
	private Connection conn;

	public DAOLoginRepository() {
		
		conn = SingleConnection.getConnection(); 
	}
	
	
	/**
	 * It checks if the user exists in the database
	 * @param user
	 * @return true if exists
	 * @throws SQLException
	 */
	public boolean loginAutentication(ModelLogin user) throws SQLException {
		
		String sql = "SELECT * FROM person "
				+ "WHERE upper(login) =? and upper(passwod)=?";
		PreparedStatement pstmt = conn.prepareStatement(sql); 
		pstmt.setString(1, user.getLogin());
		pstmt.setString(2, user.getPassword());
		ResultSet result = pstmt.executeQuery();
		
		if(result.next()) {
			return true;
		}
		
			return false;
		
		
		
	}
	
	

}
