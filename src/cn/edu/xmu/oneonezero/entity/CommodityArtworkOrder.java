package cn.edu.xmu.oneonezero.entity;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("商品订单")
@Table(name="CommodityArtworkOrder")
public class CommodityArtworkOrder extends ArtworkOrder{

	private CommodityArtwork commodityArtwork;//订单中包含的艺术品
	private double price;//订单价格
	
	@OneToOne
	public CommodityArtwork getCommodityArtwork() {
		return commodityArtwork;
	}
	public void setCommodityArtwork(CommodityArtwork commodityArtwork) {
		this.commodityArtwork = commodityArtwork;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
