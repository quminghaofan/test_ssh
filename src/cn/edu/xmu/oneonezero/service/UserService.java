package cn.edu.xmu.oneonezero.service;

import java.util.List;

import cn.edu.xmu.oneonezero.entity.User;

public interface UserService {  

	//为view层提供直接调用的接口
	public User getUser(long id);  //根据id返回一个User对象

	public void insertUser(User user);  //插入一个User

	public boolean delUser(long id);  //根据id删除一个User

	public boolean updateUser(User user);  //更新user

	public boolean isLoginSuccessful(String userName,String psw);//验证登陆信息是否正确

	public List<User> getAllUsers();//获取所有用户

	public List<User> getUserByUserName(String userName);//根据姓名获取用户

	//public List<User> getUsersByRole(String role);

	public List<User> getUsersByRole(String role);//得到所有该角色的用户

	public User getUserByUserNameAndPassword(String userName,String password);//根据用户名和密码获得用户

	public boolean isNameExist(String userName);//判断用户名是否存在

	public List<User> getAllManager();//获取所有管理员

	public void setUserStateTrue(long userId);//根据userId更改user状态为可用
	
	public List<User> getAllCommonUsersAndArtist();//获得所有普通用户和艺术家
	
	public List<User> getAllPreparativeArtist();//获得所有预备艺术家
	
	
	
}  