package cn.edu.xmu.oneonezero.entity;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("艺术品商品订单")
@Table(name="CommodityArtworkOrder")
public class CommodityArtworkOrder extends ArtworkOrder{

	private CommodityArtwork commodityArtwork;//订单中包含的艺术品
	
	
	
	public CommodityArtworkOrder(CommodityArtwork commodityArtwork) {
		super();
	}
	
	
	@OneToOne
	public CommodityArtwork getCommodityArtwork() {
		return commodityArtwork;
	}
	public void setCommodityArtwork(CommodityArtwork commodityArtwork) {
		this.commodityArtwork = commodityArtwork;
	}
	
}
