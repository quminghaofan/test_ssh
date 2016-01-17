package cn.edu.xmu.oneonezero.service;

import cn.edu.xmu.oneonezero.entity.Account;

public interface AccountService {
public Account getAccount(long id);
	/**
	 * 根据账号获取account
	 * @param accountNumber String 账号
	 * @return Account 账号
	 */
	public Account getAccountByAccountNumber(String accountNumber);//根据帐号获取account
	
	
	public void insertAccount(Account account);
	
	public void updateAccount(Account account);
	/**
	 * 验证帐号是否存在及帐号密码是否正确
	 * @param accountNumber String 账号
	 * @param password String 密码
	 * @return 验证成功返回1，失败返回0
	 */
	public boolean isLoginSuccessful(String accountNumber,String password);//验证帐号是否存在及帐号密码是否正确
	/**
	 * 根据帐号密码，和账户帐号扣除资金
	 * @param accountNumber String 账号
	 * @param password String 密码
	 * @param payAmount double 支付金额
	 * @return 帐号不存在或密码错误返回0，余额不足返回－1，成功返回1
	 */
	public int payMoney(String accountNumber, String password, double payAmount);//根据帐号密码，和账户帐号扣除资金(帐号不存在或密码错误返回0，余额不足返回－1，成功返回1)
	
}
