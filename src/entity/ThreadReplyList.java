package entity;

import java.util.Date;

/**
 * 
 * @author Samyutha
 * @version 1.0
 * @description Thread Reply List Java Bean Class including all the getters and setters
 * 
 */

public class ThreadReplyList {
	private int threadReplyId, threadId, userId;
	private String userName, replyContent;
	private Date timestamp;
	private boolean replyCreator;
	
	/**
	  * Get Thread Reply Id
	  */

	public int getThreadReplyId() {
		return threadReplyId;
	}
	
	/**
	  * Set Thread Reply Id
	  */

	public void setThreadReplyId(int threadReplyId) {
		this.threadReplyId = threadReplyId;
	}
	
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
	  * Get Reply Content
	  */

	public String getReplyContent() {
		return replyContent;
	}
	
	/**
	  * Set Reply Content
	  */

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
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
	  * Get Reply Creator
	  */

	public boolean isReplyCreator() {
		return replyCreator;
	}
	
	/**
	  * Set Reply Creator
	  */

	public void setReplyCreator(boolean replyCreator) {
		this.replyCreator = replyCreator;
	}
}
