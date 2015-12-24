package cn.edu.xmu.oneonezero.entity;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("定制艺术品订单")
@Table(name="CustomizedArtworkOrder")
public class CustomizedArtworkOrder extends ArtworkOrder{
	private CustomizedArtwork customizedArtwork;//定制的艺术品
	private double startPrice;//3个阶段价格
	private double midPrice;//
	private double endPrice;//
	private String stage;//订制所处阶段 1,2,3
	
	@OneToOne
	public CustomizedArtwork getCustomizedArtwork() {
		return customizedArtwork;
	}
	public void setCustomizedArtwork(CustomizedArtwork customizedArtwork) {
		this.customizedArtwork = customizedArtwork;
	}
	public double getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(double startPrice) {
		this.startPrice = startPrice;
	}
	public double getMidPrice() {
		return midPrice;
	}
	public void setMidPrice(double midPrice) {
		this.midPrice = midPrice;
	}
	public double getEndPrice() {
		return endPrice;
	}
	public void setEndPrice(double endPrice) {
		this.endPrice = endPrice;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	
	
	
}
