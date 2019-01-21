package jdbcDemo;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/*
 * 解决问题：
 * 1.用c3p0连接池获取连接，防止连接的无限生成
 * 2.解决事务问题，
 * 3.释放问题，连接池中的连接不一定是事务专用,因此关闭的时候不知道是否需要关闭
 * 4.解决线程问题
 * 
 * 如何使用
 * 
 * 处理事务：
 * 在Dao中 调用getConnection()方法，执行sql语句，
 * 在service中，调用开启事务，多次调用Dao中的方法，关闭事务，如果有异常，回滚事务
 * 这样就保证了service中没有暴露connection，而且在同一事务内，一定用的是同一个connection
 * 
 * 如果不是事务呢？
 * 在service层直接调用Dao中的方法就行了，所有跟事务有关的方法都不用
 */
public class JdbcTool2 {
	private static ComboPooledDataSource datasource = new ComboPooledDataSource();
	
	//事务专用的connection
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	/*
	 * 必须要有c3p0-config.xml配置文件，获取连接
	 */
	public static Connection getConnection() throws SQLException {
		Connection con = tl.get();
		if(con != null) return con;
		return datasource.getConnection();
	}
	
	public static DataSource getDataSource() {
		return datasource;
	}
	/*
	 * 开启事务，获取connection
	 * 并开启事务
	 */
	public static void beginTransaction() throws SQLException {
		Connection con = tl.get();
		if(con != null) throw new SQLException("已经开启过事务");
		con=datasource.getConnection();
		con.setAutoCommit(false);
		
		tl.set(con);
	}
	/*
	 * 提交事务，必须和开启中的连接是同一个
	 */
	public static void commitTransaction() throws SQLException {
		Connection con = tl.get();
		if(con == null) throw new SQLException("还没有开启事务");
		con.commit();
		con.close();
		System.out.println("提交事务成功，并关闭了事务专用连接！");
		// 如果关闭后的con没有变为null，下次获取的con则还在，但是没有变为null
		//con = null;
		tl.remove();
	}
	
	public static void rollbackTransaction() throws SQLException {
		Connection con = tl.get();
		if(con == null) throw new SQLException("还没有开启事务");
		con.rollback();
		con.close();
		System.out.println("由于执行过程中抛出了异常，进行回滚事务，并关闭了事务专用连接");
		//con = null;
		tl.remove();
	}
	
	/*
	 * 释放连接
	 */
	public static void releaseConnection(Connection connection) throws SQLException {
		/*
		 * 如果是事务专用，不关闭，因为在提交和回滚操作中才关闭
		 * 如果不是事务专用，是连接池发放的，只用一次，release的时候就关闭
		 */
		Connection con = tl.get();
		//如果con==null，说明现在没有事务
		if(con == null) {
			connection.close();
			System.out.println("没有进行事务，关闭该连接");
			return;
		} 
		//如果这样，说明不是事务专用，可以关闭
		if(con != connection) {
			connection.close();
			System.out.println("不是事务专用连接，关闭该连接");
		}
	}
}


