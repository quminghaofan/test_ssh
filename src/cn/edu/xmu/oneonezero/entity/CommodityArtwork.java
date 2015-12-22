package cn.edu.xmu.oneonezero.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("艺术品商品")
@Table(name="CommodityArtwork")
public class CommodityArtwork extends Artwork{
	private double price;//价格
	private String sellState;//是否卖出
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSellState() {
		return sellState;
	}
	public void setSellState(String sellState) {
		this.sellState = sellState;
	}
	
}
