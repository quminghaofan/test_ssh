package cn.edu.xmu.oneonezero.service;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.xmu.oneonezero.dao.AccountDao;
import cn.edu.xmu.oneonezero.entity.Account;

@Transactional
public class AccountServiceImpl implements AccountService{
	private AccountDao accountDao;

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public Account getAccount(long id) {
		return accountDao.getAccount(id);
	}

	@Override
	public Account getAccountByAccountNumber(String accountNumber) {
		return accountDao.getAccountByAccountNumber(accountNumber);
	}

	@Override
	public void insertAccount(Account account) {
		accountDao.insertAccount(account);
	}

	@Override
	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
	}

	@Override
	public boolean isLoginSuccessful(String accountNumber, String password) {
		return accountDao.isLoginSuccessful(accountNumber, password);
	}

	@Override
	public int payMoney(String accountNumber, String password, double payAmount) {
		return accountDao.payMoney(accountNumber, password, payAmount);
	}
	
	
	
	
}
