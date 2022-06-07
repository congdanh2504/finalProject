package Helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAO {

	private Connection connection;
	
	UserDAO() {
		connection = GetConnection.getConnection();
	}
	
	boolean login(User user) throws SQLException {
		String sql = "SELECT username, password FROM usertbl WHERE username = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getUsername());
		ResultSet resultSet = statement.executeQuery();
		if (!resultSet.next()) return false;
		String descryptedPass = PasswordEncryption.decrypt(resultSet.getString(2));
		return descryptedPass.equals(user.getPassword());
	}
	
	void signUp(User user) throws SQLException {
		String sql = "INSERT INTO usertbl (username, password) VALUES (?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getUsername());
		statement.setString(2, PasswordEncryption.encrypt(user.getPassword()));
		statement.execute();
	}
}
