package jdbcDemo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

public class JdbcTool {
	private static Properties prop = null;
	
	static {
		try {
			InputStream in = JdbcTool.class.getClassLoader()
					.getResourceAsStream("dbconfig.properties");
			prop = new Properties();
			prop.load(in);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		try {
			Class.forName(prop.getProperty("drivername"));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	} 
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(prop.getProperty("url"),
				prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test  
	public void fun1() throws SQLException {
		Connection con = JdbcTool.getConnection();
		System.out.println(con);
	}

}
