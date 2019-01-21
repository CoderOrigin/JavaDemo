package queryRunnerHandlerDemo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import jdbcDemo.JdbcTool2;

public class Dao {
	
	//该函数为Dao层的查询函数，给定一个年龄下限，一个年龄上限，直接利用handler返回一个testBean对象
	public List<testBean> query(int ageLow, int ageHigh) throws SQLException {
		
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM stu WHERE age>? && age<?";
		Connection con = JdbcTool2.getConnection();
		Object[] params = {ageLow, ageHigh};
		List<testBean> lb = qr.query(con, sql, new BeanListHandler<testBean>(testBean.class), params);
		JdbcTool2.releaseConnection(con);
		return lb;
	}
}
