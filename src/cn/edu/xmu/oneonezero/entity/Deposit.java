package cn.edu.xmu.oneonezero.entity;


public class Deposit {
		
	private long id;
	private User user;//用户
	private AuctionArtwork auctionArtwork;//拍卖的艺术品
	private double amountOfMoney;//保证金金额
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public AuctionArtwork getAuctionArtwork() {
		return auctionArtwork;
	}
	public void setAuctionArtwork(AuctionArtwork auctionArtwork) {
		this.auctionArtwork = auctionArtwork;
	}
	public double getAmountOfMoney() {
		return amountOfMoney;
	}
	public void setAmountOfMoney(double amountOfMoney) {
		this.amountOfMoney = amountOfMoney;
	}
	
	
}
