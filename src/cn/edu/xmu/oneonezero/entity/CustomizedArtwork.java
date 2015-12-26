package cn.edu.xmu.oneonezero.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("定制艺术品")
@Table(name="CustomizedArtwork")
public class CustomizedArtwork extends Artwork{
	private String startImg;//
	private String midImg;//
	private String endImg;//
	
	private String remarks;//备注
	
	
	

	public CustomizedArtwork() {
		super();
		this.startImg = "..\\images\\nopic.jpg";
		this.midImg = "..\\images\\nopic.jpg";
		this.endImg = "..\\images\\nopic.jpg";
		this.remarks = "";
	}

	public String getStartImg() {
		return startImg;
	}

	public void setStartImg(String startImg) {
		this.startImg = startImg;
	}

	public String getMidImg() {
		return midImg;
	}

	public void setMidImg(String midImg) {
		this.midImg = midImg;
	}

	public String getEndImg() {
		return endImg;
	}

	public void setEndImg(String endImg) {
		this.endImg = endImg;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
	
	
	
	
}
