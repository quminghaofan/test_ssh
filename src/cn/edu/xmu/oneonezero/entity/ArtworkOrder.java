package cn.edu.xmu.oneonezero.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
/**
 * 艺术品订单基类实体
 * @author DELL
 *
 */
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
	protected String isAccept;//是否接受订单 接受为1，拒绝为0，未审核默认为2
	
	private boolean isCancelled;//是否被取消了 true被取消了，false未被取消，默认false；
	
	protected Account payAccount;//支付账号
	
	
	
	public ArtworkOrder() {
		this.orderId = "";
		this.placeDate = new Date(new java.util.Date().getTime());
		this.state = "未支付";
		this.mobile = "";
		this.address = "";
		this.isAccept="2";
		this.isCancelled = false;
	}
	
	
	
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
	@ManyToOne(fetch=FetchType.LAZY)
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
	public String getIsAccept() {
		return isAccept;
	}
	public void setIsAccept(String isAccept) {
		this.isAccept = isAccept;
	}
	@OneToOne
	public Account getPayAccount() {
		return payAccount;
	}
	public void setPayAccount(Account payAccount) {
		this.payAccount = payAccount;
	}
	public boolean getIsCancelled() {
		return isCancelled;
	}
	public void setIsCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}
	

	
	
}
