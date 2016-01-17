package cn.edu.xmu.oneonezero.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.crypto.Data;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import cn.edu.xmu.oneonezero.dao.DataDictionaryDao;

/**
 * 用户实体
 * @author DELL
 *
 */
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
	private String description;//用户描述
	private boolean state;//是否被禁用,0是被禁用
	private String idPhoto;//审核照片
	private String noPassReason;//艺术家审核不通过的原因
	private String qqId;//
	
	
	
	public User() {
		super();
		this.name = "";
		this.nickName = "";
		this.realName = "";
		this.password = "";
		
		this.headPhoto = "..\\images\\nopic.jpg";
		this.address = "";
		this.bankCardAccount = "";
		this.description = "";
		this.state = true;
		this.idPhoto = "..\\images\\nopic.jpg";
		this.noPassReason = "";
		this.qqId="";
	}
	
	
	
	
	




	public String getQqId() {
		return qqId;
	}

	public void setQqId(String qqId) {
		this.qqId = qqId;
	}


	public String getIdPhoto() {
		return idPhoto;
	}
	public void setIdPhoto(String idPhoto) {
		this.idPhoto = idPhoto;
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
	@Cascade(CascadeType.DELETE)
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
	public boolean getState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public String getNoPassReason() {
		return noPassReason;
	}
	public void setNoPassReason(String noPassReason) {
		this.noPassReason = noPassReason;
	}
	
	
	
	
}
