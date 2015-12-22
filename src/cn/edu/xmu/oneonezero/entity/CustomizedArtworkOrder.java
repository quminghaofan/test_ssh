package cn.edu.xmu.oneonezero.entity;


import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("定制艺术品订单")
@Table(name="CustomizedArtworkOrder")
public class CustomizedArtworkOrder extends ArtworkOrder{
	private CustomizedArtwork customizedArtwork;//定制的艺术品
	private Date customizedTime;//定制时间
	private String comment;//用户评论
	private double startPrice;//3个阶段价格
	private double midPrice;//
	private double endPrice;//
	
	@OneToOne
	public CustomizedArtwork getCustomizedArtwork() {
		return customizedArtwork;
	}
	public void setCustomizedArtwork(CustomizedArtwork customizedArtwork) {
		this.customizedArtwork = customizedArtwork;
	}
	public Date getCustomizedTime() {
		return customizedTime;
	}
	public void setCustomizedTime(Date customizedTime) {
		this.customizedTime = customizedTime;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public double getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(double startPrice) {
		this.startPrice = startPrice;
	}
	public double getMidPrice() {
		return midPrice;
	}
	public void setMidPrice(double midPrice) {
		this.midPrice = midPrice;
	}
	public double getEndPrice() {
		return endPrice;
	}
	public void setEndPrice(double endPrice) {
		this.endPrice = endPrice;
	}
	
	
	
}
