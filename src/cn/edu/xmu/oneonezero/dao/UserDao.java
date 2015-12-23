package cn.edu.xmu.oneonezero.dao;

import java.util.List;

import cn.edu.xmu.oneonezero.entity.User;

public interface UserDao {


	public User getUser(long id);  //根据用户ID得到User对象

	public void insertUser(User user);  //添加用户到数据库

	public boolean delUser(long id);	//根据用户id删除User对象

	public boolean updateUser(User user);	//更新用户

	public boolean isLoginSuccessful(String userName, String psw);//验证登陆信息是否正确


	public List<User> getAllUsers();//获取所有用户

	public List<User> getUserByUserName(String userName);//根据姓名获取用户

	public List<User> getUsersByRole(String role);//得到所有该角色的用户

	public User getUserByUserNameAndPassword(String userName,String password);//根据用户名和密码获得用户

	public boolean isNameExist(String userName);//判断用户名是否存在

	public List<User> getAllManager();//获取所有管理员




}