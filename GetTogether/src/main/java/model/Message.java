package model;

import java.util.Date;

public class Message {
	private int id;
	private User receiver;
	private User sender;
	private String title;
	private Date sendDate;
	private String content;
	private boolean checked;
	
	public Message() {}
	
	public Message(int id, User receiver, User sender, String title, String content) {
		super();
		this.id = id;
		this.receiver = receiver;
		this.sender = sender;
		this.title = title;
		this.sendDate = new Date();
		this.content = content;
		this.checked = false;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
