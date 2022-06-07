package Helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/final","root","");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
