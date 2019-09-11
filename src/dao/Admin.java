/**
 * Admin Java class: connects to the database to store and retrieve information for all pages. 
 * 
 * @author samyutha
 *
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.JobListing;
import entity.MessageList;
import entity.Profile;
import entity.ThreadList;
import entity.ThreadReplyList;

/**
 * Admin method
 */

public class Admin {
	public static final String USER_SESSION_ID = "abcUserId";
	public static final String USER_SESSION_ROLE = "abcUserRole";
	public static final String USER_ROLE_ADMINISTRATOR = "Administrator";
	public static final String USER_ROLE_SOFTWARE_PROGRAMMER = "Software Programmer";

	// method for create connection
	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/abc_jobs?useLegacyDatetimeCode=false&useTimezone=true&serverTimezone=GMT%2B8",
					"root", "");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Get User Role Id
	 */

	public int getUserRoleId(String userRoleName) throws Exception {
		int userRoleId = 2;
		try {
			ResultSet rs = null;
			String sql = "SELECT UserRoleID FROM userrole WHERE UserRoleName = ?;";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, userRoleName);
			rs = ps.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					userRoleId = rs.getInt("UserRoleID");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
		return userRoleId;
	}

	/**
	 * Get User First and Last Name
	 */

	public String getUserName(int userId) throws Exception {
		String name = "User";
		try {
			ResultSet rs = null;
			String sql = "SELECT FirstName, LastName FROM users WHERE UserID = ?;";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					String firstName = rs.getString("FirstName");
					String lastName = rs.getString("LastName");
					name = firstName + " " + lastName;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
		return name;
	}

	/**
	 * Register User
	 */

	public int registerUser(int userRoleId, String firstName, String lastName, String email, String password)
			throws Exception {
		getConnection().setAutoCommit(false);
		int userId = 0, iu = 0, iue = 0;
		try {
			String sql = "INSERT INTO users (UserRoleID, Password, FirstName, LastName, Email) "
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = getConnection().prepareStatement(sql,
					java.sql.PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, userRoleId);
			ps.setString(2, password);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			ps.setString(5, email);
			iu = ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				userId = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			getConnection().rollback();
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
		if (userId > 0) {
			getConnection().setAutoCommit(false);
			try {
				String sql = "INSERT INTO userexperience (UserID) " + "VALUES (?)";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setInt(1, userId);
				iue = ps.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
				getConnection().rollback();
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}
		if (iu > 0 && iue > 0) {
			if (iu == iue) {
				return iu;
			} else {
				return iu + iue;
			}
		}
		return 0;
	}

	/**
	 * Reset Password
	 */

	public boolean resetPassword(String email, String password) throws SQLException, Exception {
		try {
			String sql = "UPDATE users " + "SET Password = ? " + "WHERE Email = ?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, email);
			int rs = ps.executeUpdate();
			return rs > 0;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return false;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	/**
	 * Login User
	 */

	public ResultSet loginUser(String email, String password) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT users.UserID, userrole.UserRoleName, users.Blocked " + "FROM users "
					+ "LEFT JOIN userrole ON users.UserRoleID = userrole.UserRoleID "
					+ "WHERE users.Email = ? AND BINARY users.Password = ?;";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	/**
	 * View profile
	 */

	public ResultSet viewProfile(int userId) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT users.Password, users.FirstName, users.LastName, users.Email, users.Mobile, users.BlockNo, users.Street, users.UnitNo, users.PostalCode, users.City, users.Country, userexperience.Education, userexperience.CompanyName, userexperience.WorkExperience, userexperience.Skills "
					+ "FROM users " + "LEFT JOIN userexperience ON users.UserID = userexperience.UserID "
					+ "WHERE users.UserID = ?;";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	/**
	 * Edit profile
	 */

	public int editProfile(int userId, String password, String firstName, String lastName, String email, int mobile,
			String blockNo, String street, String unitNo, int postalCode, String city, String country, String education,
			String companyName, String workExperience, String skills) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		int iu = 0, iue = 0;
		try {
			String sql = "UPDATE users "
					+ "SET Password = ?, FirstName = ?, LastName = ?, Email = ?, Mobile = ?, BlockNo = ?, Street = ?, UnitNo = ?, PostalCode = ?, City = ?, Country = ? "
					+ "WHERE UserID = ?;";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, email);
			ps.setInt(5, mobile);
			ps.setString(6, blockNo);
			ps.setString(7, street);
			ps.setString(8, unitNo);
			ps.setInt(9, postalCode);
			ps.setString(10, city);
			ps.setString(11, country);
			ps.setInt(12, userId);
			iu = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return 0;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
		getConnection().setAutoCommit(false);
		try {
			String sql = "UPDATE userexperience "
					+ "SET Education = ?, CompanyName = ?, WorkExperience = ?, Skills = ? " + "WHERE UserID = ?;";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, education);
			ps.setString(2, companyName);
			ps.setString(3, workExperience);
			ps.setString(4, skills);
			ps.setInt(5, userId);
			iu = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return 0;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
		if (iu > 0 && iue > 0) {
			if (iu == iue) {
				return iu;
			} else {
				return iu + iue;
			}
		}
		return 0;
	}

	/**
	 * Search profile
	 */

	public ResultSet searchProfile(String searchTerm) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT users.UserID, users.FirstName, users.LastName, users.Email, users.City, users.Country, userexperience.CompanyName "
					+ "FROM users " + "LEFT JOIN userexperience ON users.UserID = userexperience.UserID "
					+ "WHERE users.FirstName LIKE '%" + searchTerm + "%' OR users.LastName LIKE '%" + searchTerm
					+ "%' OR users.City LIKE '%" + searchTerm + "%' OR users.Country LIKE '%" + searchTerm
					+ "%' OR userexperience.CompanyName LIKE '%" + searchTerm + "%';";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	/**
	 * Get Job Listing
	 */

	public List<JobListing> getJobListing(int userId) throws SQLException, Exception {
		List<JobListing> jobs = new ArrayList<JobListing>();
		try {
			String sql = "SELECT job.JobID, job.UserID, CONCAT(users.FirstName, ' ', users.LastName) AS Lister, job.JobTitle, job.CompanyName, job.Salary, job.JobDescription, COUNT(jobapplication.JobID) AS Applicants, (SELECT COUNT(UserID) FROM jobapplication WHERE JobID = job.JobID AND UserID = ?) AS Applied "
					+ "FROM job " + "LEFT JOIN users ON job.UserID = users.UserID "
					+ "LEFT JOIN jobapplication ON job.JobID = jobapplication.JobID " + "GROUP BY job.JobID";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					JobListing job = new JobListing();
					job.setJobId(rs.getInt("JobID"));
					job.setUserId(rs.getInt("UserID"));
					job.setListedBy(rs.getString("Lister"));
					job.setTitle(rs.getString("JobTitle"));
					job.setCompanyName(rs.getString("CompanyName"));
					job.setSalary(rs.getString("Salary"));
					job.setDescription(rs.getString("JobDescription"));
					job.setApplicantCount(rs.getInt("Applicants"));
					boolean userApplied = false;
					if (rs.getInt("Applied") > 0)
						userApplied = true;
					job.setHasApplied(userApplied);
					jobs.add(job);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
		return jobs;
	}

	/**
	 * Apply Job
	 */

	public boolean applyJob(int jobId, int userId) throws SQLException, Exception {
		try {
			String sql = "INSERT INTO jobapplication (JobID, UserID) " + "VALUES (?, ?);";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, jobId);
			ps.setInt(2, userId);
			int rs = ps.executeUpdate();
			return rs > 0;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return false;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	public List<MessageList> getUserMessages(int userId) throws SQLException, Exception {
		List<MessageList> messages = new ArrayList<MessageList>();
		try {
			String sql = "SELECT MessageID, SenderUserID, (SELECT CONCAT(FirstName, ' ', LastName) FROM users WHERE UserID = SenderUserID) AS SenderName, RecipientUserID, (SELECT CONCAT(FirstName, ' ', LastName) FROM users WHERE UserID = RecipientUserID) AS RecipientName, Subject, Message, Timestamp "
					+ "FROM message " + "WHERE SenderUserID = ? OR RecipientUserID = ? " + "ORDER BY Timestamp DESC;";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, userId);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					MessageList message = new MessageList();
					message.setMessageID(rs.getInt("MessageID"));
					message.setSenderUserID(rs.getInt("SenderUserID"));
					message.setSenderName(rs.getString("SenderName"));
					message.setRecipientUserID(rs.getInt("RecipientUserID"));
					message.setRecipientName(rs.getString("RecipientName"));
					message.setSubject(rs.getString("Subject"));
					message.setMessage(rs.getString("Message"));
					message.setTimestamp(rs.getDate("Timestamp"));
					boolean isSenderUser = false;
					if (message.getSenderUserID() == userId)
						isSenderUser = true;
					message.setSenderUser(isSenderUser);
					messages.add(message);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
		return messages;
	}

	public List<MessageList> getUserMessages(int userId, int otherUserId) throws SQLException, Exception {
		List<MessageList> messages = new ArrayList<MessageList>();
		try {
			String sql = "SELECT MessageID, SenderUserID, (SELECT CONCAT(FirstName, ' ', LastName) FROM users WHERE UserID = SenderUserID) AS SenderName, RecipientUserID, (SELECT CONCAT(FirstName, ' ', LastName) FROM users WHERE UserID = RecipientUserID) AS RecipientName, Subject, Message, Timestamp "
					+ "FROM message "
					+ "WHERE (SenderUserID = ? AND RecipientUserID = ?) OR (SenderUserID = ? AND RecipientUserID = ?) "
					+ "ORDER BY Timestamp DESC;";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, otherUserId);
			ps.setInt(3, otherUserId);
			ps.setInt(4, userId);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					MessageList message = new MessageList();
					message.setMessageID(rs.getInt("MessageID"));
					message.setSenderUserID(rs.getInt("SenderUserID"));
					message.setSenderName(rs.getString("SenderName"));
					message.setRecipientUserID(rs.getInt("RecipientUserID"));
					message.setRecipientName(rs.getString("RecipientName"));
					message.setSubject(rs.getString("Subject"));
					message.setMessage(rs.getString("Message"));
					message.setTimestamp(rs.getDate("Timestamp"));
					boolean isSenderUser = false;
					if (message.getSenderUserID() == userId)
						isSenderUser = true;
					message.setSenderUser(isSenderUser);
					messages.add(message);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
		return messages;
	}

	public boolean sendMessage(int senderUserID, int recipientUserID, String subject, String message)
			throws SQLException, Exception {
		try {
			String sql = "INSERT INTO message(SenderUserID, RecipientUserID, Subject, Message, Timestamp) "
					+ "VALUES (?, ?, ?, ?, NOW());";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, senderUserID);
			ps.setInt(2, recipientUserID);
			ps.setString(3, subject);
			ps.setString(4, message);
			int rs = ps.executeUpdate();
			return rs > 0;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return false;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	public List<ThreadList> getAllThreads(int userId) throws SQLException, Exception {
		List<ThreadList> threads = new ArrayList<ThreadList>();
		try {
			String sql = "SELECT thread.ThreadID, thread.UserID, CONCAT(users.FirstName, ' ', users.LastName) AS CreatorName, thread.ThreadSubject, thread.ThreadMessage, thread.Timestamp "
					+ "FROM thread " + "LEFT JOIN users ON thread.UserID = users.UserID " + "ORDER BY Timestamp DESC;";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					ThreadList thread = new ThreadList();
					thread.setThreadId(rs.getInt("ThreadID"));
					thread.setUserId(rs.getInt("UserID"));
					thread.setUserName(rs.getString("CreatorName"));
					thread.setSubject(rs.getString("ThreadSubject"));
					thread.setMessage(rs.getString("ThreadMessage"));
					thread.setTimestamp(rs.getDate("Timestamp"));
					boolean isThreadCreator = false;
					if (thread.getUserId() == userId)
						isThreadCreator = true;
					thread.setThreadCreator(isThreadCreator);
					threads.add(thread);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
		return threads;
	}

	public List<ThreadReplyList> getThreadReplies(int threadId, int userId) throws SQLException, Exception {
		List<ThreadReplyList> replies = new ArrayList<ThreadReplyList>();
		try {
			String sql = "SELECT threadreply.ThreadReplyID, threadreply.ThreadID, threadreply.UserID, CONCAT(users.FirstName, ' ', users.LastName) AS CreatorName, threadreply.ReplyContent, threadreply.Timestamp "
					+ "FROM threadreply " + "LEFT JOIN users ON threadreply.UserID = users.UserID "
					+ "WHERE threadreply.ThreadID = ? " + "ORDER BY Timestamp DESC;";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, threadId);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					ThreadReplyList reply = new ThreadReplyList();
					reply.setThreadReplyId(rs.getInt("ThreadReplyID"));
					reply.setThreadId(rs.getInt("ThreadID"));
					reply.setUserId(rs.getInt("UserID"));
					reply.setUserName(rs.getString("CreatorName"));
					reply.setReplyContent(rs.getString("ReplyContent"));
					reply.setTimestamp(rs.getDate("Timestamp"));
					boolean isReplyCreator = false;
					if (reply.getUserId() == userId)
						isReplyCreator = true;
					reply.setReplyCreator(isReplyCreator);
					replies.add(reply);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
		return replies;
	}

	public boolean replyToThread(int threadID, int userID, String replyContent) throws SQLException, Exception {
		try {
			String sql = "INSERT INTO threadreply (ThreadID, UserID, ReplyContent, Timestamp) "
					+ "VALUES (?, ?, ?, NOW());";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, threadID);
			ps.setInt(2, userID);
			ps.setString(3, replyContent);
			int rs = ps.executeUpdate();
			return rs > 0;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return false;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	public boolean createNewThread(int userID, String subject, String message) throws SQLException, Exception {
		try {
			String sql = "INSERT INTO thread (UserID, ThreadSubject, ThreadMessage, Timestamp) "
					+ "VALUES (?, ?, ?, NOW());";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, userID);
			ps.setString(2, subject);
			ps.setString(3, message);
			int rs = ps.executeUpdate();
			return rs > 0;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return false;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	public boolean createNewJob(int userId, String title, String companyName, String salary, String description)
			throws SQLException, Exception {
		try {
			String sql = "INSERT INTO job (UserID, JobTitle, CompanyName, Salary, JobDescription) "
					+ "VALUES (?, ?, ?, ?, ?);";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setString(2, title);
			ps.setString(3, companyName);
			ps.setString(4, salary);
			ps.setString(5, description);
			int rs = ps.executeUpdate();
			return rs > 0;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return false;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	public List<Profile> getJobApplication(int jobId) throws SQLException, Exception {
		List<Profile> users = new ArrayList<Profile>();
		try {
			String sql = "SELECT users.FirstName, users.LastName, users.Email " + "FROM jobapplication "
					+ "LEFT JOIN job ON jobapplication.JobID = job.JobID "
					+ "LEFT JOIN users ON jobapplication.UserID = users.UserID " + "WHERE jobapplication.JobID = ?;";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, jobId);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Profile user = new Profile();
					user.setFirstName(rs.getString("FirstName"));
					user.setLastName(rs.getString("LastName"));
					user.setEmail(rs.getString("Email"));
					users.add(user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
		return users;
	}

	public List<Profile> getAllUsers(int userId) throws SQLException, Exception {
		List<Profile> users = new ArrayList<Profile>();
		try {
			String sql = "SELECT UserID, FirstName, LastName, Email, Blocked " + "FROM users " + "WHERE UserID <> ?;";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Profile user = new Profile();
					user.setUserID(rs.getInt("UserID"));
					user.setFirstName(rs.getString("FirstName"));
					user.setLastName(rs.getString("LastName"));
					user.setEmail(rs.getString("Email"));
					user.setBlocked(rs.getBoolean("Blocked"));
					users.add(user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
		return users;
	}

	public boolean updateUserBlock(int userId, boolean isBlocked) throws SQLException, Exception {
		try {
			System.out.println(userId + " " + isBlocked);
			String sql = "UPDATE users " + "SET Blocked = ? " + "WHERE UserID = ?;";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			// if (isBlocked) {
			// ps.setInt(1, 1);
			// } else {
			// ps.setInt(1, 0);
			// }
			ps.setBoolean(1, isBlocked);
			ps.setInt(2, userId);
			int rs = ps.executeUpdate();
			return rs > 0;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return false;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
}
