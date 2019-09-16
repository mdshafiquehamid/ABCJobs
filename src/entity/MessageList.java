package entity;

import java.util.Date;

/**
 * 
 * @author Samyutha
 * @version 1.0
 * @description Message List Java Bean Class including all the getters and setters
 * 
 */

public class MessageList {
	private int messageID, senderUserID, recipientUserID;
	private String senderName, recipientName, subject, message;
	private Date timestamp;
	private boolean senderUser;
	
	/**
	  * Get Message ID
	  */

	public int getMessageID() {
		return messageID;
	}
	
	/**
	  * Set Message ID
	  */

	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	
	/**
	  * Get Sender User ID
	  */

	public int getSenderUserID() {
		return senderUserID;
	}
	
	/**
	  * Set Sender User ID
	  */

	public void setSenderUserID(int senderUserID) {
		this.senderUserID = senderUserID;
	}
	
	/**
	  * Get Recipient User ID
	  */

	public int getRecipientUserID() {
		return recipientUserID;
	}
	
	/**
	  * Set Recipient User ID
	  */

	public void setRecipientUserID(int recipientUserID) {
		this.recipientUserID = recipientUserID;
	}
	
	/**
	  * Get Sender Name
	  */

	public String getSenderName() {
		return senderName;
	}
	
	/**
	  * Set Sender Name
	  */

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	
	/**
	  * Get Recipient Name
	  */

	public String getRecipientName() {
		return recipientName;
	}
	
	/**
	  * Set Recipient Name
	  */

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	
	/**
	  * Get Subject
	  */

	public String getSubject() {
		return subject;
	}
	
	/**
	  * Set Subject
	  */

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	  * Get Message
	  */

	public String getMessage() {
		return message;
	}
	
	/**
	  * Set Message
	  */

	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	  * Get Timestamp
	  */

	public Date getTimestamp() {
		return timestamp;
	}
	
	/**
	  * Set Timestamp
	  */

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	/**
	  * Get Sender User
	  */

	public boolean isSenderUser() {
		return senderUser;
	}
	
	/**
	  * Set Sender User
	  */

	public void setSenderUser(boolean isSenderUser) {
		this.senderUser = isSenderUser;
	}
}
