package cn.edu.xmu.oneonezero.service;

import cn.edu.xmu.oneonezero.entity.User;

public interface UserService {  

//为view层提供直接调用的接口
public User getUser(long id);  //根据id返回一个User对象

public void insertUser(User user);  //插入一个User

public boolean delUser(long id);  //根据id删除一个User

public boolean updateUser(User user);  //更新user

public boolean isLoginSuccessful(String userName,String psw);//验证登陆信息是否正确

}  