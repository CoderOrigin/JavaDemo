package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JdbcDemo {

	/*
	 * ClassNotFoundException：没导驱动包
	 * SQLException:1.三个参数出错，2.mysql没开启
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
	}
	
	@Test
	public void fun1() throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		/*
		 * jdbc四大参数
		 * driverClassName : com.mysql.jdbc.Driver
		 * url:  jdbc:mysql://localhost:3306/mydb1
		 * username: root
		 * password: 123456
		 */
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mydb1";
		String username = "root";
		String password = "123456";
		Connection con = DriverManager.getConnection(url, username, password);
		
		//使用connection创建statement对象
		Statement stmt = con.createStatement();
		//利用statement对象进行增、删、改
		String sql = "INSERT INTO stu VALUES('ada', 'Li', 29, 'female')";
		int r = stmt.executeUpdate(sql);
		System.out.println(r);
		//查： 返回一张表格
		
		stmt.close();
		con.close();
	}
	
	@Test
	public void fun2() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1","root","123456");
		
		Statement stmt = con.createStatement();
		
		//进行查找操作
		String sql = "SELECT * FROM stu";
		ResultSet rs =  stmt.executeQuery(sql);
		
		while(rs.next()) {
			String name = rs.getString(2);
			int age = rs.getInt(3);
			System.out.println(name + " : " + age);
		}
		
		rs.close();
		stmt.close();
		con.close();
	}
	
	//因为异常问题，需要规范化代码格式
	@Test
	public void query() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/onlineshop", "root", "123456");
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user");
			
			int count = rs.getMetaData().getColumnCount();
			while(rs.next()) { //遍历行
				for(int i = 1; i<=count; i++) {
					System.out.print(rs.getString(i));
					if(i < count) {
						System.out.print(",");
					}
				}
				System.out.println();
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {}
		}
	}
	
	//利用JdbcTool进行建立连接，并利用preparedstatement进行执行mysql语句，并进行批量处理
	@Test
	public void batchInsert() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT stu VALUES (?,?,?,?)";
			
			con = JdbcTool.getConnection();
			pstmt = con.prepareStatement(sql);
			
			for(int i=0;i<3000;i++) {
				pstmt.setString(1, "test"+i);
				pstmt.setString(2, "name"+i);
				pstmt.setInt(3, i+20);
				pstmt.setString(4, i%2==0?"male":"female");				
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			
		}catch(Exception e) {
			throw new RuntimeException();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				throw new RuntimeException();
			}
		}
	}
}
