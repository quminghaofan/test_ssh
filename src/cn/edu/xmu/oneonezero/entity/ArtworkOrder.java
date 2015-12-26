package cn.edu.xmu.oneonezero.entity;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@DiscriminatorColumn(name="orderType",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("订单")
@Table(name="ArtworkOrder")
public class ArtworkOrder {
	protected long id;
	protected String orderId;//订单编号
	protected User user;//下订单的用户

	@Temporal(TemporalType.TIMESTAMP)
	protected Date placeDate;//下单时间
//	protected String payState;//支付状态
//	protected String deliverState;//发货状态
//	protected String receiveState;//收获状态
	protected String state;//未支付、已支付未发货、已支付未收货、已支付已收货
	protected String mobile;//联系方式
	protected String address;//发货地址
	protected boolean isAccept;//是否接受订单
	
	protected Account payAccount;//支付账号
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@ManyToOne
	@JoinColumn(name="userId")
	@Cascade(CascadeType.ALL)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getPlaceDate() {
		return placeDate;
	}
	public void setPlaceDate(Date placeDate) {
		this.placeDate = placeDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean getIsAccept() {
		return isAccept;
	}
	public void setIsAccept(boolean isAccept) {
		this.isAccept = isAccept;
	}
	@OneToOne
	public Account getPayAccount() {
		return payAccount;
	}
	public void setPayAccount(Account payAccount) {
		this.payAccount = payAccount;
	}
	

	
	
}
