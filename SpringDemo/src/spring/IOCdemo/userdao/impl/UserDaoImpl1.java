package spring.IOCdemo.userdao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import spring.IOCdemo.userdao.UserDao;

/*
 * jdbc四大参数
 * driverClassName : com.mysql.jdbc.Driver
 * url:  jdbc:mysql://localhost:3306/mydb1
 * username: root
 * password: 123456
 * 
 * 
 * 不能再无参数构造函数中调用 使用set方法依赖注入的成员，
 * 因为无参构造函数比set方法先调用
 */
public class UserDaoImpl1 implements UserDao{
	private Map<String, String> jdbcarg;
	private Connection con = null;
	
	public UserDaoImpl1() {
		System.out.println("userDaoImpl1对象被创建了，需要依赖注入数据库参数");
	}
	
	public Map<String, String> getJdbcarg() {
		return jdbcarg;
	}

	public void setJdbcarg(Map<String, String> jdbcarg) {
		this.jdbcarg = jdbcarg;
	}
	
	public Connection getConnection() throws Exception {
		String driver = jdbcarg.get("driver");
		String url = jdbcarg.get("url");;
		String user = jdbcarg.get("user");;
		String password = jdbcarg.get("password");;
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
		return con;
	}
	@Override
	public void doFind() throws Exception {
		Connection con = getConnection();
		String sql = "SELECT * From stu";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		System.out.println(rs);
		rs.close();
		ps.close();
		con.close();
	}

	@Override
	public void doInsert() {
		// TODO Auto-generated method stub
		
	}
	
	
}
