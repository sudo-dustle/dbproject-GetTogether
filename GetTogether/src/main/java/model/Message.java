package model;

import java.util.Date;

public class Message {
	private int id;
	private Member receiver;
	private Member sender;
	private String title;
	private Date sendDate;
	private String content;
	private boolean checked;
	
	public Message() {}
	
	//check용..
	public Message(int id, Member receiver, Member sender, String title, Date sendDate, String content,
			boolean checked) {
		super();
		this.id = id;
		this.receiver = receiver;
		this.sender = sender;
		this.title = title;
		this.sendDate = sendDate;
		this.content = content;
		this.checked = checked;
	}



	//create용 자동지정 생성
	public Message(Member receiver, Member sender, String title, String content) {
		super();
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
	public Member getReceiver() {
		return receiver;
	}
	public void setReceiver(Member receiver) {
		this.receiver = receiver;
	}
	public Member getSender() {
		return sender;
	}
	public void setSender(Member sender) {
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
