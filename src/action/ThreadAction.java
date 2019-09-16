package action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.Admin;
import entity.ThreadList;
import entity.ThreadReplyList;

/**
 * 
 * @author Samyutha
 * @version 1.0
 * @description ThreadAction class for all thread functionalities: post, view and reply to thread
 * 
 */

public class ThreadAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private static final String HOME = "HOME";
	private static final String ERROR = "ERROR";
	private static final String LIST = "LIST";
	private static final String VIEW = "VIEW";

	private enum SubmitType {
		Home, Error, List, View, Reply, Create
	};

	private Map<String, Object> session;
	private SubmitType submit;
	private List<ThreadList> threads;
	private List<ThreadReplyList> threadReplies;
	private int threadId;
	private String threadSubject, threadMessage, threadCreatorName;
	private Date threadCreatedOn;
	private String threadReplyMessage;
	private String pageMessage, pageMessageStyle;
	private String newThreadSubject, newThreadMessage, newThreadStatus, newThreadStatusStyle;

	@Override
	public String execute() throws Exception {
		switch (submit) {
		case Home:
			return HOME;

		case Error:
			return ERROR;

		case List:
			int userId = (int) session.get(Admin.USER_SESSION_ID);
			Admin admin = new Admin();
			threads = admin.getAllThreads(userId);
			if (threads.size() == 0) {
				pageMessageStyle = "font-weight: bold;";
				pageMessage = "No threads listed";
			}
			return LIST;

		case View:
			if (threadId > 0) {
				userId = (int) session.get(Admin.USER_SESSION_ID);
				admin = new Admin();
				threadReplies = admin.getThreadReplies(threadId, userId);
				if (threadReplies.size() == 0) {
					pageMessageStyle = "font-weight: bold;";
					pageMessage = "No thread replies";
				}
			}
			return VIEW;

		case Reply:
			userId = (int) session.get(Admin.USER_SESSION_ID);
			admin = new Admin();
			pageMessageStyle = "color: red;";
			if (threadReplyMessage == null || threadReplyMessage == "") {
				pageMessage = "Reply cannot be empty";
			} else if (!admin.replyToThread(threadId, userId, threadReplyMessage)) {
				pageMessage = "An error occurred when replying to thread";
			}
			if (threadId > 0) {
				threadReplies = admin.getThreadReplies(threadId, userId);
				if (threadReplies.size() == 0) {
					pageMessageStyle = "font-weight: bold;";
					pageMessage = "No thread replies";
				}
			}
			return VIEW;

		case Create:
			newThreadStatusStyle = "color: red;";
			userId = (int) session.get(Admin.USER_SESSION_ID);
			admin = new Admin();
			if (newThreadSubject == null || newThreadSubject == "") {
				newThreadStatus = "Subject cannot be empty";
			} else if (newThreadMessage == null || newThreadMessage == "") {
				newThreadStatus = "Message cannot be empty";
			} else if(!admin.createNewThread(userId, newThreadSubject, newThreadMessage)) {
				newThreadStatus = "An error occurred when creating a new thread";
			}
			threads = admin.getAllThreads(userId);
			if (threads.size() == 0) {
				pageMessageStyle = "font-weight: bold;";
				pageMessage = "No threads listed";
			}
			return LIST;
		}

		return HOME;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getUserName() {
		String userName = "";
		try {
			int userId = (int) session.get(Admin.USER_SESSION_ID);
			Admin admin = new Admin();
			userName = admin.getUserName(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userName;
	}

	public boolean isUserAdmin() {
		try {
			String userRole = (String) session.get(Admin.USER_SESSION_ROLE);
			if (userRole.equalsIgnoreCase(Admin.USER_ROLE_ADMINISTRATOR)) {
				return true;
			} else if (userRole.equalsIgnoreCase(Admin.USER_ROLE_SOFTWARE_PROGRAMMER)) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public SubmitType getSubmit() {
		return submit;
	}

	public void setSubmit(SubmitType submit) {
		this.submit = submit;
	}

	public List<ThreadList> getThreads() {
		return threads;
	}

	public void setThreads(List<ThreadList> threads) {
		this.threads = threads;
	}

	public List<ThreadReplyList> getThreadReplies() {
		return threadReplies;
	}

	public void setThreadReplies(List<ThreadReplyList> threadReplies) {
		this.threadReplies = threadReplies;
	}

	public int getThreadId() {
		return threadId;
	}

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}

	public String getThreadSubject() {
		return threadSubject;
	}

	public void setThreadSubject(String threadSubject) {
		this.threadSubject = threadSubject;
	}

	public String getThreadMessage() {
		return threadMessage;
	}

	public void setThreadMessage(String threadMessage) {
		this.threadMessage = threadMessage;
	}

	public String getThreadCreatorName() {
		return threadCreatorName;
	}

	public void setThreadCreatorName(String threadCreatorName) {
		this.threadCreatorName = threadCreatorName;
	}

	public Date getThreadCreatedOn() {
		return threadCreatedOn;
	}

	public void setThreadCreatedOn(Date threadCreatedOn) {
		this.threadCreatedOn = threadCreatedOn;
	}

	public String getThreadReplyMessage() {
		return threadReplyMessage;
	}

	public void setThreadReplyMessage(String threadReplyMessage) {
		this.threadReplyMessage = threadReplyMessage;
	}

	public String getPageMessage() {
		return pageMessage;
	}

	public void setPageMessage(String pageMessage) {
		this.pageMessage = pageMessage;
	}

	public String getPageMessageStyle() {
		return pageMessageStyle;
	}

	public void setPageMessageStyle(String pageMessageStyle) {
		this.pageMessageStyle = pageMessageStyle;
	}

	public String getNewThreadSubject() {
		return newThreadSubject;
	}

	public void setNewThreadSubject(String newThreadSubject) {
		this.newThreadSubject = newThreadSubject;
	}

	public String getNewThreadMessage() {
		return newThreadMessage;
	}

	public void setNewThreadMessage(String newThreadMessage) {
		this.newThreadMessage = newThreadMessage;
	}

	public String getNewThreadStatus() {
		return newThreadStatus;
	}

	public void setNewThreadStatus(String newThreadStatus) {
		this.newThreadStatus = newThreadStatus;
	}

	public String getNewThreadStatusStyle() {
		return newThreadStatusStyle;
	}

	public void setNewThreadStatusStyle(String newThreadStatusStyle) {
		this.newThreadStatusStyle = newThreadStatusStyle;
	}
}
