package cn.edu.xmu.oneonezero.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="User")
public class User {
	private long id;
	private String name;
	private String nickName;
	private String realName;//真实姓名
	private String password;
	private DataDictionary role;//角色
	private String mobile;
	private String headPhoto;
	private String address;
	private String bankCardAccount;
	private String description;
	private String state;//是否被禁用
	private String idPhoto;//审核照片
	
	public String getIdPhoto() {
		return idPhoto;
	}
	public void setIdPhoto(String idPhoto) {
		this.idPhoto = idPhoto;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@ManyToOne
	@JoinColumn(name="roleId")
	@Cascade(CascadeType.ALL)
	public DataDictionary getRole() {
		return role;
	}
	public void setRole(DataDictionary role) {
		this.role = role;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getHeadPhoto() {
		return headPhoto;
	}
	public void setHeadPhoto(String headPhoto) {
		this.headPhoto = headPhoto;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBankCardAccount() {
		return bankCardAccount;
	}
	public void setBankCardAccount(String bankCardAccount) {
		this.bankCardAccount = bankCardAccount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	
	
	
}
