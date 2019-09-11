package entity;

import java.util.Date;

public class MessageList {
	private int messageID, senderUserID, recipientUserID;
	private String senderName, recipientName, subject, message;
	private Date timestamp;
	private boolean senderUser;

	public int getMessageID() {
		return messageID;
	}

	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}

	public int getSenderUserID() {
		return senderUserID;
	}

	public void setSenderUserID(int senderUserID) {
		this.senderUserID = senderUserID;
	}

	public int getRecipientUserID() {
		return recipientUserID;
	}

	public void setRecipientUserID(int recipientUserID) {
		this.recipientUserID = recipientUserID;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isSenderUser() {
		return senderUser;
	}

	public void setSenderUser(boolean isSenderUser) {
		this.senderUser = isSenderUser;
	}
}
