package cn.edu.xmu.oneonezero.dao;

import cn.edu.xmu.oneonezero.entity.Account;

public interface AccountDao {
	public Account getAccount(long id);
	
	public Account getAccountByAccountNumber(String accountNumber);//根据帐号获取account
	
	
	public void insertAccount(Account account);
	
	public void updateAccount(Account account);
	
	public boolean isLoginSuccessful(String accountNumber,String password);//验证帐号是否存在及帐号密码是否正确
	
	public int payMoney(String accountNumber, String password, double payAmount);//根据帐号密码，和账户帐号扣除资金(帐号不存在或密码错误返回0，余额不足返回－1，成功返回1)
	
	
}
