package entity;

import java.util.Date;

public class ThreadList {
	private int threadId, userId;
	private String userName, subject, message;
	private Date timestamp;
	private boolean threadCreator;

	public int getThreadId() {
		return threadId;
	}

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public boolean isThreadCreator() {
		return threadCreator;
	}

	public void setThreadCreator(boolean threadCreator) {
		this.threadCreator = threadCreator;
	}
}
