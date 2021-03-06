package cn.edu.xmu.oneonezero.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 艺术品商品实体
 * @author DELL
 *
 */
@Entity
@DiscriminatorValue("艺术品商品")
@Table(name="CommodityArtwork")
public class CommodityArtwork extends Artwork{
	private double price;//价格
	private boolean sellState;//卖出否：true：没卖出
	private boolean canSell;//是否可卖 
	
	
	
	public CommodityArtwork() {
		super();
		this.price = 0;
		this.sellState = true;
		this.canSell = true;
	}
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
	public boolean getCanSell() {
		return canSell;
	}
	public void setCanSell(boolean canSell) {
		this.canSell = canSell;
	}
	
}
