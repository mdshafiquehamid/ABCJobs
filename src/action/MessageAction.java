package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.Admin;
import entity.MessageList;

/**
 * 
 * @author Samyutha
 * @version 1.0
 * @description MessageAction class for all the message functionalities: send, view and reply back to messages
 * 
 */

public class MessageAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private static final String HOME = "HOME";
	private static final String ERROR = "ERROR";
	private static final String LIST = "LIST";
	private static final String VIEW = "VIEW";

	private enum SubmitType {
		Home, Error, List, View, New
	};

	private Map<String, Object> session;
	private SubmitType submit;
	private List<MessageList> messages;
	private int otherUserId;
	private String otherUserName;
	private String newSubject, newMessage;
	private String pageMessage, pageMessageStyle;

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
			messages = admin.getUserMessages(userId);
			if (messages.size() == 0) {
				pageMessageStyle = "font-weight: bold;";
				pageMessage = "No messages listed";
			} else {
				// Only get unique last messages
				List<Integer> addedUserIds = new ArrayList<Integer>();
				List<MessageList> newMessages = new ArrayList<MessageList>();
				for (MessageList message : messages) {
					if (message.getSenderUserID() != userId && !addedUserIds.contains(message.getSenderUserID())) {
						newMessages.add(message);
						addedUserIds.add(message.getSenderUserID());
					} else if (message.getRecipientUserID() != userId
							&& !addedUserIds.contains(message.getRecipientUserID())) {
						newMessages.add(message);
						addedUserIds.add(message.getRecipientUserID());
					}
				}
				messages = newMessages;
			}
			return LIST;

		case View:
			if (otherUserId > 0) {
				userId = (int) session.get(Admin.USER_SESSION_ID);
				admin = new Admin();
				messages = admin.getUserMessages(userId, otherUserId);
			}
			return VIEW;

		case New:
			pageMessageStyle = "color: red;";
			pageMessage = "";
			userId = (int) session.get(Admin.USER_SESSION_ID);
			if (userId > 0 && otherUserId > 0) {
				admin = new Admin();
				newSubject = "";// Remove this entire line if you want to add subject to messaging
				// if (newSubject == null || newSubject == "") {
				// pageMessage = "Subject cannot be empty";
				// } else
				if (newMessage == null || newMessage == "") {
					pageMessage = "Message cannot be empty";
				} else if (!admin.sendMessage(userId, otherUserId, newSubject, newMessage)) {
					pageMessage = "An error occurred when sending message";
				}
				messages = admin.getUserMessages(userId, otherUserId);
				if (pageMessage == "") {
					newSubject = "";
					newMessage = "";
				}
			} else {
				pageMessage = "An error occurred";
			}
			return VIEW;
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

	public List<MessageList> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageList> messages) {
		this.messages = messages;
	}

	public int getOtherUserId() {
		return otherUserId;
	}

	public void setOtherUserId(int otherUserId) {
		this.otherUserId = otherUserId;
	}

	public String getOtherUserName() {
		return otherUserName;
	}

	public void setOtherUserName(String otherUserName) {
		this.otherUserName = otherUserName;
	}

	public String getNewSubject() {
		return newSubject;
	}

	public void setNewSubject(String newSubject) {
		this.newSubject = newSubject;
	}

	public String getNewMessage() {
		return newMessage;
	}

	public void setNewMessage(String newMessage) {
		this.newMessage = newMessage;
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
}
