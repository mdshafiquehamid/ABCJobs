package entity;

import java.util.Date;

public class ThreadReplyList {
	private int threadReplyId, threadId, userId;
	private String userName, replyContent;
	private Date timestamp;
	private boolean replyCreator;

	public int getThreadReplyId() {
		return threadReplyId;
	}

	public void setThreadReplyId(int threadReplyId) {
		this.threadReplyId = threadReplyId;
	}

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

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isReplyCreator() {
		return replyCreator;
	}

	public void setReplyCreator(boolean replyCreator) {
		this.replyCreator = replyCreator;
	}
}
