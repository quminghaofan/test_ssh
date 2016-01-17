package cn.edu.xmu.oneonezero.service;

import java.util.List;

import cn.edu.xmu.oneonezero.entity.User;

public interface UserService {  

	//为view层提供直接调用的接口
	/**
	 * 根据id返回一个User对象
	 * @param id long 用户id
	 * @return User 用户
	 */
	public User getUser(long id);  //根据id返回一个User对象
/**
 * 插入一个User
 * @param user User 用户
 */
	public void insertUser(User user);  //插入一个User
/**
 * 更新user
 * @param user User 用户
 */
	public void updateUser(User user);  //更新user
/**
 * 验证登陆信息是否正确
 * @param userName String 用户名
 * @param psw String 密码
 * @return 验证成功返回1，失败返回0
 */
	public boolean isLoginSuccessful(String userName,String psw);//验证登陆信息是否正确
/**
 * 获取所有用户
 * @return List<User> 用户列表
 */
	public List<User> getAllUsers();//获取所有用户
/**
 * 根据姓名获取用户(1表示获取预备艺术家，2表示所有艺术家和普通用户，0表示管理员)
 * @param userName String 用户名
 * @param type String 用户类型
 * @return List<User> 用户列表
 */
	public List<User> getUserByUserName(String userName,String type);//根据姓名获取用户(1表示获取预备艺术家，2表示所有艺术家和普通用户，0表示管理员)
	/**
	 * 根据姓名获取预备艺术家
	 * @param userName String 用户名
	 * @return List<User> 用户列表
	 */
	public List<User> getPreparativeUserByUserName(String userName);//根据姓名获取预备艺术家

	//public List<User> getUsersByRole(String role);
/**
 * 得到所有该角色的用户
 * @param role String 角色
 * @return List<User> 用户列表
 */
	public List<User> getUsersByRole(String role);//得到所有该角色的用户
/**
 * 根据用户名和密码获得用户
 * @param userName String 用户名
 * @param password String 密码
 * @return User 用户
 */
	public User getUserByUserNameAndPassword(String userName,String password);//根据用户名和密码获得用户
/**
 * 判断用户名是否存在
 * @param userName String 用户名
 * @return 存在返回1，不存在返回0
 */
	public boolean isNameExist(String userName);//判断用户名是否存在
/**
 * 获取所有管理员(包括普通管理员、主编、采编)
 * @return 管理员列表
 */
	public List<User> getAllManager();//获取所有管理员(包括普通管理员、主编、采编)
/**
 * 获得所有普通用户和艺术家
 * @return 普通用户和艺术家列表
 */
	public List<User> getAllCommonUsersAndArtist();//获得所有普通用户和艺术家
	/**
	 * 获得所有预备艺术家
	 * @return 预备艺术家列表
	 */
	public List<User> getAllPreparativeArtist();//获得所有预备艺术家
	/**
	 * 根据userId更改user状态,true为启用，false为禁用
	 * @param userId long 用户id
	 * @param state Boolean 用户状态
	 */
	public void setUserState(long userId,boolean state);//根据userId更改user状态,true为启用，false为禁用
	/**
	 * 根据用户id修改用户密码
	 * @param userId long 用户id
	 * @param psw String 密码
	 */
	public void updatePasswordByUserId(long userId,String psw);//根据用户id修改用户密码

	

	
	
	
	
}  