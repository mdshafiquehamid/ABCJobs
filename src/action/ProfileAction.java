package action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.Admin;
import entity.Profile;
/**
 * 
 * @author samyu
 * 
 *
 */
public class ProfileAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private static final String HOME = "HOME";
	private static final String ERROR = "ERROR";
	private static final String VIEW = "VIEW";
	private static final String EDIT = "EDIT";
	private static final String SEARCH = "SEARCH";
	private static final String LIST = "LIST";
	private static final String BLOCK = "BLOCK";

	private enum SubmitType {
		Home, Error, View, Edit, Update, Search, List, Block
	};

	private Map<String, Object> session;
	private SubmitType submit;
	private String password;
	private String firstName, lastName, email, blockNo, street, unitNo, city, country;
	private String education, companyName, workExperience, skills;
	private int mobile, postalCode;
	private String message;
	private String search;
	private List<Profile> users;
	private int usersUserId;
	private boolean blocked;

	@Override
	public String execute() throws Exception {
		switch (submit) {
		case Home:
			return HOME;

		case Error:
			return ERROR;

		case View:
			try {
				Admin admin = new Admin();
				int userId = (int) session.get(Admin.USER_SESSION_ID);
				ResultSet rs = admin.viewProfile(userId);
				if (rs != null) {
					if (rs.next()) {
						setPassword(rs.getString("Password"));
						setFirstName(rs.getString("FirstName"));
						setLastName(rs.getString("LastName"));
						setEmail(rs.getString("Email"));
						setMobile(rs.getInt("Mobile"));
						setBlockNo(rs.getString("BlockNo"));
						setStreet(rs.getString("Street"));
						setUnitNo(rs.getString("UnitNo"));
						setPostalCode(rs.getInt("PostalCode"));
						setCity(rs.getString("City"));
						setCountry(rs.getString("Country"));
						setEducation(rs.getString("Education"));
						setCompanyName(rs.getString("CompanyName"));
						setWorkExperience(rs.getString("WorkExperience"));
						setSkills(rs.getString("Skills"));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return VIEW;

		case Edit:
			try {
				Admin admin = new Admin();
				int userId = (int) session.get(Admin.USER_SESSION_ID);
				ResultSet rs = admin.viewProfile(userId);
				if (rs != null) {
					if (rs.next()) {
						setPassword(rs.getString("Password"));
						setFirstName(rs.getString("FirstName"));
						setLastName(rs.getString("LastName"));
						setEmail(rs.getString("Email"));
						setMobile(rs.getInt("Mobile"));
						setBlockNo(rs.getString("BlockNo"));
						setStreet(rs.getString("Street"));
						setUnitNo(rs.getString("UnitNo"));
						setPostalCode(rs.getInt("PostalCode"));
						setCity(rs.getString("City"));
						setCountry(rs.getString("Country"));
						setEducation(rs.getString("Education"));
						setCompanyName(rs.getString("CompanyName"));
						setWorkExperience(rs.getString("WorkExperience"));
						setSkills(rs.getString("Skills"));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return EDIT;

		case Update:
			int userId = (int) session.get(Admin.USER_SESSION_ID);
			Admin admin = new Admin();
			if (firstName == null || firstName == "") {
				message = "First name cannot be blank";
				return ERROR;
			} else if (lastName == null || lastName == "") {
				message = "Last name cannot be blank";
				return ERROR;
			} else if (email == null || email == "") {
				message = "Email cannot be blank";
				return ERROR;
			} else if (password == null || password == "") {
				message = "Password cannot be blank";
				return ERROR;
			}
			admin.editProfile(userId, password, firstName, lastName, email, mobile, blockNo, street, unitNo, postalCode,
					city, country, education, companyName, workExperience, skills);
			return VIEW;

		case Search:
			if (search == null) {
				return HOME;
			}
			users = new ArrayList<Profile>();
			try {
				userId = (int) session.get(Admin.USER_SESSION_ID);
				admin = new Admin();
				ResultSet rs = admin.searchProfile(search);
				if (rs != null) {
					while (rs.next()) {
						Profile user = new Profile();
						user.setUserID(rs.getInt("UserID"));
						user.setFirstName(rs.getString("FirstName"));
						user.setLastName(rs.getString("LastName"));
						user.setEmail(rs.getString("Email"));
						user.setCity(rs.getString("City"));
						user.setCountry(rs.getString("Country"));
						user.setCompanyName(rs.getString("CompanyName"));
						if (userId != user.getUserID())
							users.add(user);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (users.size() == 0) {
				message = "No profiles found";
			}
			return SEARCH;

		case List:
			userId = (int) session.get(Admin.USER_SESSION_ID);
			admin = new Admin();
			users = admin.getAllUsers(userId);
			if (users.size() == 0) {
				message = "No users found";
			}
			return LIST;

		case Block:
			System.out.println(blocked);
			userId = (int) session.get(Admin.USER_SESSION_ID);
			admin = new Admin();
			admin.updateUserBlock(usersUserId, !blocked);
			users = admin.getAllUsers(userId);
			if (users.size() == 0) {
				message = "No users found";
			}
			return BLOCK;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getBlockNo() {
		return blockNo;
	}

	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getUnitNo() {
		return unitNo;
	}

	public void setUnitNo(String unitNo) {
		this.unitNo = unitNo;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public List<Profile> getUsers() {
		return users;
	}

	public void setUsers(List<Profile> users) {
		this.users = users;
	}

	public int getUsersUserId() {
		return usersUserId;
	}

	public void setUsersUserId(int usersUserId) {
		this.usersUserId = usersUserId;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
}
