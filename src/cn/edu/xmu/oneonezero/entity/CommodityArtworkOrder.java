package cn.edu.xmu.oneonezero.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("商品订单")
public class CommodityArtworkOrder extends ArtworkOrder{

	private Set<CommodityArtwork> commodityArtworks;//订单中包含的艺术品
	private double price;//订单价格
	
	@OneToMany(targetEntity=CommodityArtwork.class)
	public Set<CommodityArtwork> getCommodityArtworks() {
		return commodityArtworks;
	}
	public void setCommodityArtworks(Set<CommodityArtwork> commodityArtworks) {
		this.commodityArtworks = commodityArtworks;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
