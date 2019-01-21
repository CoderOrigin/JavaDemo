package jdbcDemo;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;


public class queryRunnerDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		//这里为service层，处理事务，但不能和数据库有关系
		
		try {
			JdbcTool2.beginTransaction();
			changeDao("Changed2990", "name2990");
			changeDao("Changed2993", "name2993");
			JdbcTool2.commitTransaction();
		}catch (Exception e) {
			JdbcTool2.rollbackTransaction();
		}
		//这里应该分开成Dao和Service来做demo
		
	}
	
	@Test
	public void ServiceChange() throws SQLException {
		changeDao("Changed2990", "name2990");
	}
	//Dao层的change方法，接受的参数为name，和changedName
	public static void changeDao(String changedName, String name) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "UPDATE stu SET name=? WHERE name=?";
		Connection con = JdbcTool2.getConnection();
		Object[] params = {changedName, name};
		qr.execute(con, sql, params);
		JdbcTool2.releaseConnection(con);
	}

}
