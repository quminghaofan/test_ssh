package cn.edu.xmu.oneonezero.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.oneonezero.entity.Account;
import cn.edu.xmu.oneonezero.entity.User;

public class AccountDaoImpl implements AccountDao{
	private SessionFactory sessionFactory;//创建一个会话工厂实例


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Account getAccount(long id) {
		String hql = "from Account a where a.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, id);
		
		return (Account)query.uniqueResult();
		
	}

	@Override
	public void insertAccount(Account account) {
		sessionFactory.getCurrentSession().saveOrUpdate(account);
	}

	@Override
	public void updateAccount(Account account) {
		sessionFactory.getCurrentSession().saveOrUpdate(account);	
	}



	@Override
	public Account getAccountByAccountNumber(String accountNumber) {
		String hql = "from Account a where a.accountNumber=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, accountNumber);
		
		return (Account)query.uniqueResult();
		

	}

	@Override
	public boolean isLoginSuccessful(String accountNumber, String password) {
		if(getAccountByAccountNumber(accountNumber).equals(null))
			return false;
		else if(!getAccountByAccountNumber(accountNumber).getPassword().equals(password))
			return false;
		return true;
	
	}
	
	@Override
	public int payMoney(String accountNumber, String password, double payAmount) {
		if(isLoginSuccessful(accountNumber, password))
			return 0;
		else 
			{
				double balance=getAccountByAccountNumber(accountNumber).getBalance();
				if(payAmount>balance)
					return -1;
				else
				{
					getAccountByAccountNumber(accountNumber).setBalance(balance-payAmount);
					return 1;
				}
			}
	}
	
	
	
}
