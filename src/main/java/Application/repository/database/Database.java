package Application.repository.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	static final String URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String NAME = "root";
	static final String PASS = "";

	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, NAME, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
