package crudjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

	public Connection getConnection() throws SQLException {
		return ConnectionFactory.getConnection();
	}

	public void create(User user) throws SQLException {
		String sql = "insert into users(name, email) values(?,?)";
		PreparedStatement stmt = getConnection().prepareStatement(sql);
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getEmail());
		stmt.execute();

	}

	public ResultSet readAll() throws SQLException {
		
		String sql = "select * from users";
		Statement stmt = getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		return rs;
	}
	
	public ResultSet readById(int id) throws SQLException {
		String sql = "select * from users where id = ?";
		PreparedStatement stmt = getConnection().prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		return rs;
	}
	
	public void update(User user, int id) throws SQLException {
		String sql = "update users set name = ?, email = ? where id = ?";
		PreparedStatement stmt = getConnection().prepareStatement(sql);
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getEmail());
		stmt.setInt(3, id);
		stmt.execute();
	}
	
	public void delete(int id) throws SQLException {
		String sql = "delete from users where id = ?";
		PreparedStatement stmt = getConnection().prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
	}

}
