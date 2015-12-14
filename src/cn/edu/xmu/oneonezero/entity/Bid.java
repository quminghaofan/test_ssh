package cn.edu.xmu.oneonezero.entity;

import java.sql.Date;

public class Bid {
		
	private long id;
	private AuctionArtwork auctionArtwork;//出价的艺术品
	private User user;//出价的用户
	private Date placeTime;//出价的时间
	private double bidPrice;//出的价格
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public AuctionArtwork getAuctionArtwork() {
		return auctionArtwork;
	}
	public void setAuctionArtwork(AuctionArtwork auctionArtwork) {
		this.auctionArtwork = auctionArtwork;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getPlaceTime() {
		return placeTime;
	}
	public void setPlaceTime(Date placeTime) {
		this.placeTime = placeTime;
	}
	public double getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}
	
	
	
	
}
