package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.Admin;

import email.MailSender;

/**
 * 
 * @author Samyutha
 * @version 1.0
 * @description EmailAction class which consists of email functionalities to send bulk email
 * 
 */

public class EmailAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private static final String HOME = "HOME";
	private static final String ERROR = "ERROR";
	private static final String SEND = "SEND";
	private static final String BULK = "BULK";

	private enum SubmitType {
		Home, Error, Send, Bulk
	};

	private Map<String, Object> session;
	private SubmitType submit;
	private String to, subject, message;
	private String statusMessage, statusMessageStyle;

	@Override
	public String execute() throws Exception {
		switch (submit) {
		case Home:
			return HOME;

		case Error:
			return ERROR;

		case Send:
			return SEND;

		case Bulk:
			statusMessageStyle = "color: red;";
			if (to == null || to == "") {
				statusMessage = "Send to cannot be blank";
				return ERROR;
			} else if (subject == null || subject == "") {
				statusMessage = "Subject cannot be blank";
				return ERROR;
			} else if (message == null || message == "") {
				statusMessage = "Message cannot be blank";
				return ERROR;
			}
			List<String> sendToRecipients = new ArrayList<String>();
			String[] recipients = to.split(";");
			for (int i = 0; i < recipients.length; i++) {
				if (recipients[i] != null && recipients[i] != "") {
					sendToRecipients.add(recipients[i]);
				}
			}
			MailSender mailSender = new MailSender();
			Admin admin = new Admin();
			try {
				mailSender.sendSSLMessage(sendToRecipients, message, subject);
				admin.sendBulkEmail(to, message, subject);
				statusMessageStyle = "color: blue;";
				statusMessage = "Email sent successfully";
				to = "";
				subject = "";
				message = "";
			} catch (MessagingException e) {
				e.printStackTrace();
				statusMessage = "Some error occurred while sending email";
			}
			return BULK;
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

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
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

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getStatusMessageStyle() {
		return statusMessageStyle;
	}

	public void setStatusMessageStyle(String statusMessageStyle) {
		this.statusMessageStyle = statusMessageStyle;
	}
}
