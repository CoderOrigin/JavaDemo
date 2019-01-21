package queryRunnerHandlerDemo;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

public class Service {
	private Dao dao = new Dao();
	
	//Service层处理事务，只和Dao层联系，不直接联系数据库
	//得到query方法返回的list，将其列出来
	@Test
	public void showListTestBean() throws SQLException {
		List<testBean> list = dao.query(3000, 3100);
		for(testBean item : list) {
			System.out.println(item.getName() + item.getAge() + item.getGender());
		}
	}
}
