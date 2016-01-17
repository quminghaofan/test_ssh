package cn.edu.xmu.oneonezero.dao;

import cn.edu.xmu.oneonezero.entity.Account;
/**
 * 用户账户，用于模拟支付
 * @author DELL
 *
 */
public interface AccountDao {
	/**
	 * 根据id获取账户信息
	 * @param id 账户id
	 * @return Account
	 */
	public Account getAccount(long id);
	
	/**
	 * 根据帐号获取account
	 * @param accountNumber 账号
	 * @return Account
	 */
	public Account getAccountByAccountNumber(String accountNumber);//
	
	/**
	 * 添加账户
	 * @param account 账户信息
	 */
	public void insertAccount(Account account);
	
	/**
	 * 更新账户
	 * @param account 账户信息
	 */
	public void updateAccount(Account account);
	
	/**
	 * 验证帐号是否存在及帐号密码是否正确
	 * @param accountNumber 账号
	 * @param password 密码
	 * @return boolean
	 */
	public boolean isLoginSuccessful(String accountNumber,String password);
	
	/**
	 * 根据帐号密码，和账户帐号，扣除资金(帐号不存在或密码错误返回0，余额不足返回－1，成功返回1)
	 * @param accountNumber 账号
	 * @param password 密码
	 * @param payAmount 扣除资金
	 * @return int
	 */
	public int payMoney(String accountNumber, String password, double payAmount);
	
	
}
