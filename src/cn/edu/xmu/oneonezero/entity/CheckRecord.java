package cn.edu.xmu.oneonezero.entity;

import java.sql.Date;

public class CheckRecord {
		private long id;
		private User fromUser;//从
		private User toUser;//到
		private Date time;//发送时间
		private String content;//发送内容
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public User getFromUser() {
			return fromUser;
		}
		public void setFromUser(User fromUser) {
			this.fromUser = fromUser;
		}
		public User getToUser() {
			return toUser;
		}
		public void setToUser(User toUser) {
			this.toUser = toUser;
		}
		public Date getTime() {
			return time;
		}
		public void setTime(Date time) {
			this.time = time;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		
		
		
	
}
