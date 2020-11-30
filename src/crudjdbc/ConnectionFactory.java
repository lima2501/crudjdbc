package crudjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static String url = "jdbc:mysql://localhost/crudjdbc?verifyServerCertificate=false&useSSL=true";
	private static String user = "root";
	private static String password = "123456";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

}
