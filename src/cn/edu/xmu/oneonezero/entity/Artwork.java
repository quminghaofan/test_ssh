package cn.edu.xmu.oneonezero.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@NamedQueries({
	@NamedQuery(name="getArtworksByType",query="from  Artwork a where a.isExist=true and a.type.name like ? "),
	@NamedQuery(name="getArtworksByTypeAndArtworkName",query="from Artwork a where a.isExist=true and a.type.name= ? and a.name like ? "),
	@NamedQuery(name="getArtworksByAuthorName",query="from  Artwork a where a.isExist=true and a.author like ? "),
	@NamedQuery(name="getArtworkByArtworkId",query="from  Artwork a where a.isExist=true and a.id = ? ")
	
})
@Entity
@DiscriminatorColumn(name="artworkType",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("普通艺术品")
@Table(name="Artwork")
public class Artwork {
	protected long id;
	protected String name;
	protected String author;//作者
	protected User owner;//持有用户
	protected String picUrl;//图片路径
	protected String artworkDescription;//描述
	protected DataDictionary type;//类别
	protected boolean isExist;//用于判断该商品是否存在
	
	

	public Artwork() {
		this.name = "";
		this.author = "";
		this.owner=null;
		this.picUrl = "..\\images\\nopic.jpg";
		this.artworkDescription = "";
		this.type = null;
		this.isExist = true;
	}
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@ManyToOne
	@JoinColumn(name="ownerId")
	@Cascade(CascadeType.ALL)
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	@Type(type="text")
	public String getArtworkDescription() {
		return artworkDescription;
	}
	public void setArtworkDescription(String artworkDescription) {
		this.artworkDescription = artworkDescription;
	}
	
	@ManyToOne
	@JoinColumn(name="typeId")
	@Cascade(CascadeType.ALL)
	public DataDictionary getType() {
		return type;
	}
	public void setType(DataDictionary type) {
		this.type = type;
	}
	
	public boolean getIsExist() {
		return isExist;
	}
	public void setIsExist(boolean isExist) {
		this.isExist = isExist;
	}
	
}
