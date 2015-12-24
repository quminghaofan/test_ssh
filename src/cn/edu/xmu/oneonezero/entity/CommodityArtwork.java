package cn.edu.xmu.oneonezero.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sun.org.apache.xpath.internal.operations.Bool;

@Entity
@DiscriminatorValue("艺术品商品")
@Table(name="CommodityArtwork")
public class CommodityArtwork extends Artwork{
	private double price;//价格
	private boolean sellState;//是否卖出
	private boolean canSell;//是否可卖
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean getSellState() {
		return sellState;
	}
	public void setSellState(Boolean sellState) {
		this.sellState = sellState;
	}
	public boolean isCanSell() {
		return canSell;
	}
	public void setCanSell(boolean canSell) {
		this.canSell = canSell;
	}
	
}
