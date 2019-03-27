package spring.IOCdemo.userservice.impl;

import spring.IOCdemo.userdao.UserDao;
import spring.IOCdemo.userservice.UserService;

public class UserServiceImpl1 implements UserService {
	private UserDao userDao1 = null;
	
	public UserServiceImpl1() {
		System.out.println("userServiceImpl1对象被创建了,该对象需要依赖注入Dao");
	}
	
	public void setUserDao1(UserDao userDao1) {
		this.userDao1 = userDao1;
	}

	@Override
	public void doSometing() {
		// TODO Auto-generated method stub
		
	}
	
	public void doFind() throws Exception {
		userDao1.doFind();
	}

}
