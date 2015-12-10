package cn.edu.xmu.oneonezero.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorColumn(name="orderType",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("订单")
@Table(name="ArtworkOrder")
public class ArtworkOrder {
	private long id;
	private String orderId;//订单编号
	private String name;
	@Temporal(TemporalType.TIMESTAMP)
	private Date placeDate;//下单时间
	private String payState;//支付状态
	private String deliverState;//发货状态
	private String receiveState;//收获状态
	private String mobile;//联系方式
	private String address;//发货地址
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getPlaceDate() {
		return placeDate;
	}
	public void setPlaceDate(Date placeDate) {
		this.placeDate = placeDate;
	}
	public String getPayState() {
		return payState;
	}
	public void setPayState(String payState) {
		this.payState = payState;
	}
	public String getDeliverState() {
		return deliverState;
	}
	public void setDeliverState(String deliverState) {
		this.deliverState = deliverState;
	}
	public String getReceiveState() {
		return receiveState;
	}
	public void setReceiveState(String receiveState) {
		this.receiveState = receiveState;
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
	

	
	
}
