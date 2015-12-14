package cn.edu.xmu.oneonezero.entity;

import java.sql.Date;

public class AuctionArtwork extends Artwork{
	private double floorPrice;//底价
	private String state;//状态
	private Date startTime;
	private Date endTime;
	private double finalPrice;//成交价
	public double getFloorPrice() {
		return floorPrice;
	}
	public void setFloorPrice(double floorPrice) {
		this.floorPrice = floorPrice;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	
	
}
