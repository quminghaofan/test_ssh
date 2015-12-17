package cn.edu.xmu.oneonezero.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="News")
public class News {
	private long id;
	private String name;
	private String content;
	private String picUrl;//加一个编写时间
	private String onShowTime;
	private String offShowTime;
	private String rank;
	private User editor;//采编
	private User chiefEditor;//主编
	private String state;//软文的状态
	private double price;//软文的价格
	private String newsType;//软文or新闻
	
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

	public String getOnShowTime() {
		return onShowTime;
	}
	public void setOnShowTime(String onShowTime) {
		this.onShowTime = onShowTime;
	}
	public String getOffShowTime() {
		return offShowTime;
	}
	public void setOffShowTime(String offShowTime) {
		this.offShowTime = offShowTime;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	@ManyToOne
	@JoinColumn(name="editorId")
	@Cascade(CascadeType.ALL)
	public User getEditor() {
		return editor;
	}
	public void setEditor(User editor) {
		this.editor = editor;
	}
	@ManyToOne
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
