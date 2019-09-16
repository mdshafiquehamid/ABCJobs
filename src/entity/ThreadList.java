package entity;

import java.util.Date;

/**
 * 
 * @author Samyutha
 * @version 1.0
 * @description Thread List Bean Class including all the getters and setters
 * 
 */

public class ThreadList {
	private int threadId, userId;
	private String userName, subject, message;
	private Date timestamp;
	private boolean threadCreator;
	
	/**
	  * Get Thread Id
	  */

	public int getThreadId() {
		return threadId;
	}
	
	/**
	  * Set Thread Id
	  */

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}
	
	/**
	  * Get User Id
	  */

	public int getUserId() {
		return userId;
	}
	
	/**
	  * Set User Id
	  */

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/**
	  * Get User Name
	  */

	public String getUserName() {
		return userName;
	}
	
	/**
	  * Set User Name
	  */

	public void setUserName(String userName) {
		this.userName = userName;
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
	  * Get Thread Creator
	  */

	public boolean isThreadCreator() {
		return threadCreator;
	}
	
	/**
	  * Set Thread Creator
	  */

	public void setThreadCreator(boolean threadCreator) {
		this.threadCreator = threadCreator;
	}
}
