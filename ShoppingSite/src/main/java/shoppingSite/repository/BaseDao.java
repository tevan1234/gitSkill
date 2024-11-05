package shoppingSite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	protected static Connection conn;
	
	static {
		String username = "root";
		String password = "root1234";
		String dbUrl = "jdbc:mysql://localhost:3306/ShoppingSite?serverTimezone=Asia/Taipei&characterEncoding=utf-8&useUnicode=true";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, username, password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
