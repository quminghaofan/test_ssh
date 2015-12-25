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
	public User getUser(long id) {
		return userDao.getUser(id);
	}

	@Override
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
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
	public List<User> getUsersByRole(String role) {
		return userDao.getUsersByRole(role);
	}


	@Override
	public User getUserByUserNameAndPassword(String userName, String password) {
		return userDao.getUserByUserNameAndPassword(userName, password);
	}


	@Override
	public boolean isNameExist(String userName) {
		return userDao.isNameExist(userName);
	}


	@Override
	public List<User> getAllManager() {
		return userDao.getAllManager();
	}




	@Override
	public List<User> getAllCommonUsersAndArtist() {
		return userDao.getAllCommonUsersAndArtist();
	}


	@Override
	public List<User> getAllPreparativeArtist() {
		return userDao.getAllPreparativeArtist();
	}


	@Override
	public void setUserState(long userId,boolean state) {
		userDao.setUserState(userId,state);
	}




	@Override
	public List<User> getPreparativeUserByUserName(String userName) {
		return userDao.getPreparativeUserByUserName(userName);
	}




	@Override
	public List<User> getUserByUserName(String userName, String type) {
		if(type.equals("0"))
			return userDao.getAllUsers();
		else if(type.equals("1"))
			return userDao.getPreparativeUserByUserName(userName);
		else
			return userDao.getCommonUsersAndArtistByUserName(userName);
	}

}
