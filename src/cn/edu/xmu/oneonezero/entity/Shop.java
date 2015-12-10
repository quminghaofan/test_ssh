package cn.edu.xmu.oneonezero.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Shop")
public class Shop {
	private long id;
	private String name;
	private User owner;
	private Set<CommodityArtwork> commodityArtworks;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	@OneToMany
	public Set<CommodityArtwork> getCommodityArtProducts() {
		return commodityArtworks;
	}
	public void setCommodityArtProducts(Set<CommodityArtwork> commodityArtworks) {
		this.commodityArtworks = commodityArtworks;
	}
	
	
	
	
}
