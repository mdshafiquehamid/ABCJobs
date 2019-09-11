package action;

import java.sql.ResultSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.Admin;
import dao.EmailApi;

public class RegistrationAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private static final String HOME = "HOME";
	private static final String ERROR = "ERROR";
	private static final String LOGIN = "LOGIN";
	private static final String LOGOUT = "LOGOUT";
	private static final String REGISTER = "REGISTER";
	private static final String REGISTER_DETAILS_BACK = "REGISTER_DETAILS_BACK";
	private static final String REGISTER_DETAILS_CONFIRM = "REGISTER_DETAILS_CONFIRM";
	private static final String FORGOT = "FORGOT";
	private static final String RESET = "RESET";
	private static final String RESET_CONFIRM = "RESET_CONFIRM";

	private enum SubmitType {
		Home, Error, Login, Logout, Register, ForgotPassword, RegisterDetailsBack, RegisterDetailsConfirm,
		ResetPassword, ResetPasswordConfirm
	};

	private Map<String, Object> session;
	private SubmitType submit;
	private String loginMessage, loginStyle, loginEmail, loginPassword;
	private String registerMessage, registerStyle, registerFirstName, registerLastName, registerEmail, registerPassword;
	private String forgotMessage, forgotStyle, forgotEmail;
	private String resetMessage, resetStyle, resetEmail, resetPassword;

	@Override
	public String execute() throws Exception {
		// TODO: MUST REMOVE THIS LINES BEFORE SUBMISSION
		loginEmail = "htonnae@miibeian.gov.cn"; // 15
		loginPassword = "bgV4QEXdUDI";
		loginEmail = "kshickle9@cnbc.com"; // 10
		loginPassword = "YzPI4Ug";
		switch (submit) {
		case Home:
			return HOME;

		case Error:
			return ERROR;

		case Login:
			loginStyle = "color:red";
			if (loginEmail == null || loginEmail == "") {
				loginMessage = "Email cannot be blank";
				return ERROR;
			} else if (loginPassword == null || loginPassword == "") {
				loginMessage = "Password cannot be blank";
				return ERROR;
			}
			try {
				loginMessage = "Either your email or password is wrong";
				Admin admin = new Admin();
				ResultSet rs = admin.loginUser(loginEmail, loginPassword);
				if (rs != null) {
					if (rs.next()) {
						int userId = rs.getInt("UserID");
						String userRole = rs.getString("UserRoleName");
						boolean isBlocked = rs.getBoolean("Blocked");
						session.put(Admin.USER_SESSION_ID, userId);
						session.put(Admin.USER_SESSION_ROLE, userRole);
						if (isBlocked) {
							loginMessage = "Your account has been blocked";
						} else {
							loginMessage = "";
							return LOGIN;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				loginMessage = "An error has occurred!";
			}
			return ERROR;

		case Logout:
			session.clear();
			return LOGOUT;

		case Register:
			registerStyle = "color:red";
			if (registerFirstName == null || registerFirstName == "") {
				registerMessage = "First name cannot be blank";
				return ERROR;
			} else if (registerLastName == null || registerLastName == "") {
				registerMessage = "Last name cannot be blank";
				return ERROR;
			} else if (registerEmail == null || registerEmail == "") {
				registerMessage = "Email cannot be blank";
				return ERROR;
			} else if (registerPassword == null || registerPassword == "") {
				registerMessage = "Password cannot be blank";
				return ERROR;
			}
			registerStyle = "color:blue";
			registerMessage = registerFirstName + " " + registerLastName + " " + registerEmail + " " + registerPassword;
			return REGISTER;

		case RegisterDetailsBack:
			registerStyle = "color:blue";
			registerMessage = "Please edit your details";
			return REGISTER_DETAILS_BACK;

		case RegisterDetailsConfirm:
			registerStyle = "color:red";
			Admin admin = new Admin();
			try {
				int userRoleId = admin.getUserRoleId(Admin.USER_ROLE_SOFTWARE_PROGRAMMER);
				int rs = admin.registerUser(userRoleId, registerFirstName, registerLastName, registerEmail,
						registerPassword);
				rs = userRoleId;
				if (rs > 0) {
					if (!EmailApi.sendEmail(true)) {
						registerMessage = "Registration was successful but could not send email to " + registerEmail;
						return ERROR;
					}
					return REGISTER_DETAILS_CONFIRM;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			registerMessage = "An error has occurred!";
			return ERROR;

		case ForgotPassword:
			forgotStyle = "color:red";
			if (forgotEmail == null || forgotEmail == "") {
				forgotMessage = "Email cannot be blank";
				return ERROR;
			}
			if (EmailApi.sendEmail(true)) {
				forgotStyle = "color:green";
				forgotMessage = "Email has been sent to " + forgotEmail;
			} else
				forgotMessage = "Could not send email to " + forgotEmail;
			return FORGOT;

		case ResetPassword:
			// http://localhost:8080/ABCJobs/registration?submit=ResetPassword&resetEmail=mail%40site.domain
			resetStyle = "color:blue";
			resetMessage = "Please enter your new password";
			return RESET;

		case ResetPasswordConfirm:
			resetStyle = "color:red";
			if (resetPassword == null || resetPassword == "") {
				resetMessage = "Password cannot be blank";
				return RESET;
			}
			admin = new Admin();
			if (admin.resetPassword(resetEmail, resetPassword)) {
				loginEmail = resetEmail;
				loginStyle = "color:blue";
				loginMessage = "Please login with your new password";
			} else {
				forgotEmail = resetEmail;
				forgotStyle = "color:red";
				forgotMessage = "An error occurred please try again";
			}
			return RESET_CONFIRM;
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

	public String getLoginMessage() {
		return loginMessage;
	}

	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}

	public String getLoginStyle() {
		return loginStyle;
	}

	public void setLoginStyle(String loginStyle) {
		this.loginStyle = loginStyle;
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getRegisterMessage() {
		return registerMessage;
	}

	public void setRegisterMessage(String registerMessage) {
		this.registerMessage = registerMessage;
	}

	public String getRegisterStyle() {
		return registerStyle;
	}

	public void setRegisterStyle(String registerStyle) {
		this.registerStyle = registerStyle;
	}

	public String getRegisterFirstName() {
		return registerFirstName;
	}

	public void setRegisterFirstName(String registerFirstName) {
		this.registerFirstName = registerFirstName;
	}

	public String getRegisterLastName() {
		return registerLastName;
	}

	public void setRegisterLastName(String registerLastName) {
		this.registerLastName = registerLastName;
	}

	public String getRegisterEmail() {
		return registerEmail;
	}

	public void setRegisterEmail(String registerEmail) {
		this.registerEmail = registerEmail;
	}

	public String getRegisterPassword() {
		return registerPassword;
	}

	public void setRegisterPassword(String registerPassword) {
		this.registerPassword = registerPassword;
	}

	public String getForgotMessage() {
		return forgotMessage;
	}

	public void setForgotMessage(String forgotMessage) {
		this.forgotMessage = forgotMessage;
	}

	public String getForgotStyle() {
		return forgotStyle;
	}

	public void setForgotStyle(String forgotStyle) {
		this.forgotStyle = forgotStyle;
	}

	public String getForgotEmail() {
		return forgotEmail;
	}

	public void setForgotEmail(String forgotEmail) {
		this.forgotEmail = forgotEmail;
	}

	public String getResetMessage() {
		return resetMessage;
	}

	public void setResetMessage(String resetMessage) {
		this.resetMessage = resetMessage;
	}

	public String getResetStyle() {
		return resetStyle;
	}

	public void setResetStyle(String resetStyle) {
		this.resetStyle = resetStyle;
	}

	public String getResetEmail() {
		return resetEmail;
	}

	public void setResetEmail(String resetEmail) {
		this.resetEmail = resetEmail;
	}

	public String getResetPassword() {
		return resetPassword;
	}

	public void setResetPassword(String resetPassword) {
		this.resetPassword = resetPassword;
	}
}
