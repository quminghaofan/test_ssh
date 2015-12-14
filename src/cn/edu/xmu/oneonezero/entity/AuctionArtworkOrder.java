package cn.edu.xmu.oneonezero.entity;

import java.sql.Date;

public class AuctionArtworkOrder extends ArtworkOrder{
	private AuctionArtwork auctionArtwork;//拍卖的艺术品
	private Date placeTime;//下单时间
	
	public AuctionArtwork getAuctionArtwork() {
		return auctionArtwork;
	}
	public void setAuctionArtwork(AuctionArtwork auctionArtwork) {
		this.auctionArtwork = auctionArtwork;
	}
	public Date getPlaceTime() {
		return placeTime;
	}
	public void setPlaceTime(Date placeTime) {
		this.placeTime = placeTime;
	}
	
	
}
