package spring.IOCdemo.userservice.impl;

import spring.IOCdemo.userdao.UserDao;
import spring.IOCdemo.userservice.UserService;

public class UserServiceImpl2 implements UserService {
	private UserDao userDao2 = null;
	
	public void setUserDao2(UserDao userDao2) {
		this.userDao2 = userDao2;
	}
	
	@Override
	public void doSometing() {
		// TODO Auto-generated method stub
		
	}


}
