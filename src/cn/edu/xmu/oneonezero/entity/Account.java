package cn.edu.xmu.oneonezero.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;


@Entity
@Table(name="Account")
//@NamedNativeQueries({
//	@NamedNativeQuery(name="getAccountById",query="from Account a where a.id=?"),
//	@NamedNativeQuery(name="getAccountByAccountNumber",query="from Account a where a.accountNumber=?")
//})
public class Account {
	private long id;
	private String accountNumber;
	private String password;
	private double balance;//余额
	
	
	
	public Account() {
		accountNumber="";
		password="";
		balance=0;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
