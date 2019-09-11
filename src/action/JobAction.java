package action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.Admin;
import entity.JobListing;
import entity.Profile;
/**
 * 
 * @author samyu
 *
 *
 */
public class JobAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private static final String HOME = "HOME";
	private static final String ERROR = "ERROR";
	private static final String LIST = "LIST";
	private static final String NEW = "NEW";
	private static final String CREATE = "CREATE";
	private static final String VIEW = "VIEW";

	private enum SubmitType {
		Home, Error, List, Apply, New, Create, View
	};

	private Map<String, Object> session;
	private SubmitType submit;
	private List<JobListing> jobs;
	private List<Profile> users;
	private int jobId;
	private String message, messageStyle;
	private String title, companyName, salary, description;

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
			jobs = admin.getJobListing(userId);
			if (jobs.size() == 0) {
				messageStyle = "font-weight: bold;";
				message = "No jobs listed";
			}
			return LIST;

		case Apply:
			userId = (int) session.get(Admin.USER_SESSION_ID);
			admin = new Admin();
			if (admin.applyJob(jobId, userId)) {
				messageStyle = "font-weight: bold; color: blue;";
				message = "Your job has been applied";
			} else {
				messageStyle = "font-weight: bold; color: red;";
				message = "An error occured when trying to apply to job";
			}
			jobs = admin.getJobListing(userId);
			return LIST;

		case New:
			return NEW;

		case Create:
			messageStyle = "color: red;";
			userId = (int) session.get(Admin.USER_SESSION_ID);
			admin = new Admin();
			if (title == null || title == "") {
				message = "Title cannot be empty";
			} else if (companyName == null || companyName == "") {
				message = "Company name cannot be empty";
			} else if (salary == null || salary == "") {
				message = "Salary cannot be empty";
			} else if (description == null || description == "") {
				message = "Description cannot be empty";
			} else if (!admin.createNewJob(userId, title, companyName, salary, description)) {
				message = "An error occurred when creating a new job";
			} else {
				title = "";
				companyName = "";
				salary = "";
				description = "";
				messageStyle = "color: blue;";
				message = "Job created successfully";
			}
			return CREATE;

		case View:
			admin = new Admin();
			users = admin.getJobApplication(jobId);
			if (users.size() == 0) {
				messageStyle = "font-weight: bold;";
				message = "No users have applied";
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

	public List<JobListing> getJobs() {
		return jobs;
	}

	public void setJobs(List<JobListing> jobs) {
		this.jobs = jobs;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageStyle() {
		return messageStyle;
	}

	public void setMessageStyle(String messageStyle) {
		this.messageStyle = messageStyle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Profile> getUsers() {
		return users;
	}

	public void setUsers(List<Profile> users) {
		this.users = users;
	}
}
