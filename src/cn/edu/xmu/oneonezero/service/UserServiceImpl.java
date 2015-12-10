package cn.edu.xmu.oneonezero.service;

import java.util.List;

import cn.edu.xmu.oneonezero.dao.UserDao;
import cn.edu.xmu.oneonezero.entity.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao; //创建一个UserDao实例

	public void setUserDao(UserDao userDao) {  
	    this.userDao = userDao;
	}


	@Override
	public boolean delUser(long id) {
		return userDao.delUser(id);
	}


	@Override
	public User getUser(long id) {
		return userDao.getUser(id);
	}

	@Override
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}


	@Override
	public boolean isLoginSuccessful(String userName, String psw) {
		return userDao.isLoginSuccessful(userName, psw);
	}


	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}


	@Override
	public List<User> getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}


	@Override
	public List<User> getUsersByRole(String role) {
		return userDao.getUsersByRole(role);
	}


	@Override
	public User getUserByUserNameAndPassword(String userName, String password) {
		return userDao.getUserByUserNameAndPassword(userName, password);
	}

}
