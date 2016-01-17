package cn.edu.xmu.oneonezero.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
/**
 * 软文实体
 * @author DELL
 *
 */
@Entity
@Table(name="News")
public class News {
	private long id;
	private String name;
	private String content;
	private String picUrl;//加一个编写时间
	private Date onShowTime;
	private Date offShowTime;
	private String rank;
	private User editor;//采编
	private User chiefEditor;//主编
	private String state;//软文的状态 未审核、审核不通过、审核通过、草稿
	private double price;//软文的价格
	private String newsType;//资讯、广告
	
	
	
	public News() {
		super();
		this.name = "";
		this.content = "";
		this.picUrl = "..\\images\\nopic.jpg";
		this.onShowTime = new Date(new java.util.Date().getTime());
		this.offShowTime = new Date(new java.util.Date().getTime());
		this.rank = "";
		this.state = "未审核";
		this.price = 0;
		this.newsType = "资讯";
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public Date getOnShowTime() {
		return onShowTime;
	}
	public void setOnShowTime(Date onShowTime) {
		this.onShowTime = onShowTime;
	}
	public Date getOffShowTime() {
		return offShowTime;
	}
	public void setOffShowTime(Date offShowTime) {
		this.offShowTime = offShowTime;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="editorId")
	@Cascade(CascadeType.ALL)
	public User getEditor() {
		return editor;
	}
	public void setEditor(User editor) {
		this.editor = editor;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="chiefEditorId")
	@Cascade(CascadeType.ALL)
	public User getChiefEditor() {
		return chiefEditor;
	}
	public void setChiefEditor(User chiefEditor) {
		this.chiefEditor = chiefEditor;
	}
	
	

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getNewsType() {
		return newsType;
	}
	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}
	
	
	
	
}
