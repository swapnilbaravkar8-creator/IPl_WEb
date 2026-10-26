package ipldemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class PlayerConnection {

	public Connection getConnection() throws Exception {

		String url = "jdbc:mysql://localhost:3306/ipl_tab?createDatabaseIfNotExist=true";
		String username = "root";
		String password = "rootpass";

		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection(url, username, password);
	}
}
