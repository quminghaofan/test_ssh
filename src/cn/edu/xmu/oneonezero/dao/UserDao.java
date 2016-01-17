package cn.edu.xmu.oneonezero.dao;

import java.util.List;

import cn.edu.xmu.oneonezero.entity.User;

/**
 * 用户
 * @author DELL
 *
 */
public interface UserDao {

	/**
	 * 根据用户ID得到User对象
	 * @param id 用户ID
	 * @return User
	 */
	public User getUser(long id);  //

	/**
	 * 添加用户到数据库
	 * @param user 用户信息
	 */
	public void insertUser(User user);  //

	/**
	 * 更新用户
	 * @param user 用户信息
	 */
	public void updateUser(User user);	//

	/**
	 * 验证登陆信息是否正确
	 * @param userName 用户名
	 * @param psw 密码
	 * @return boolean
	 */
	public boolean isLoginSuccessful(String userName, String psw);//

	/**
	 * 获取所有用户
	 * @return List
	 */
	public List<User> getAllUsers();//

	/**
	 * 根据用户名获取普通用户
	 * @param userName 用户名
	 * @return List
	 */
	public List<User> getUserByUserName(String userName);//
	
	/**
	 * 根据用户名获取预备艺术家
	 * @param userName 用户名
	 * @return List
	 */
	public List<User> getPreparativeUserByUserName(String userName);//
	
	/**
	 * 根据用户名获取普通管理员/采编/主编
	 * @param userName 用户名
	 * @return List
	 */
	public List<User> getManagersByUserName(String userName);//

	/**
	 * 得到所有该角色的用户
	 * @param role 角色名称
	 * @return List
	 */
	public List<User> getUsersByRole(String role);//

	/**
	 * 根据用户名和密码获得用户
	 * @param userName 用户名
	 * @param password 密码
	 * @return User
	 */
	public User getUserByUserNameAndPassword(String userName,String password);//

	/**
	 * 判断用户名是否存在
	 * @param userName 用户名
	 * @return boolean
	 */
	public boolean isNameExist(String userName);//

	/**
	 * 获取所有管理员(包括普通管理员、主编、采编)
	 * @return List
	 */
	public List<User> getAllManager();//

	/**
	 * 根据userId更改user状态
	 * @param userId 用户id
	 * @param state 状态
	 */
	public void setUserState(long userId,boolean state);//
	
	/**
	 * 获得所有普通用户和艺术家
	 * @return List
	 */
	public List<User> getAllCommonUsersAndArtist();//
	
	/**
	 * 获得所有预备艺术家
	 * @return List
	 */
	public List<User> getAllPreparativeArtist();//
	
	/**
	 * 在所有普通用户和艺术家中根据用户名查找
	 * @param userName 用户名
	 * @return List
	 */
	public List<User> getCommonUsersAndArtistByUserName(String userName);//

	/**
	 * 根据用户id修改用户密码
	 * @param userId 用户id
	 * @param psw 用户密码
	 */
	public void updatePasswordByUserId(long userId,String psw);//


}