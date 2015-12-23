package cn.edu.xmu.oneonezero.dao;

import java.util.List;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import cn.edu.xmu.oneonezero.entity.User;

public interface UserDao {


	public User getUser(long id);  //根据用户ID得到User对象

	public void insertUser(User user);  //添加用户到数据库

	public void updateUser(User user);	//更新用户

	public boolean isLoginSuccessful(String userName, String psw);//验证登陆信息是否正确


	public List<User> getAllUsers();//获取所有用户

	public List<User> getUserByUserName(String userName);//根据姓名获取用户

	public List<User> getUsersByRole(String role);//得到所有该角色的用户

	public User getUserByUserNameAndPassword(String userName,String password);//根据用户名和密码获得用户

	public boolean isNameExist(String userName);//判断用户名是否存在

	public List<User> getAllManager();//获取所有管理员(包括普通管理员、主编、采编)

	public void setUserStateTrue(long userId);//根据userId更改user状态为可用
	
	public void setUserStateFalse(long userId);//根据userId更改user状态为禁用

	public List<User> getAllCommonUsersAndArtist();//获得所有普通用户和艺术家
	
	public List<User> getAllPreparativeArtist();//获得所有预备艺术家
	




}