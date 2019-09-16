package entity;

/**
 * 
 * @author Samyutha
 * @version 1.0
 * @description Job Listing Java Bean Class including all the getters and setters
 * 
 */

public class JobListing {
	int jobId, userId, applicantCount;
	String listedBy, title, companyName, salary, description;
	boolean hasApplied;
	
	/**
	  * Get Job Id
	  */

	public int getJobId() {
		return jobId;
	}
	
	/**
	  * Set Job Id
	  */

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	
	/**
	  * Get Applicant Count
	  */

	public int getApplicantCount() {
		return applicantCount;
	}
	
	/**
	  * Set Applicant Count
	  */

	public void setApplicantCount(int applicantCount) {
		this.applicantCount = applicantCount;
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
	  * Get Listed By
	  */
	
	public String getListedBy() {
		return listedBy;
	}
	
	/**
	  * Set Listed By
	  */

	public void setListedBy(String listedBy) {
		this.listedBy = listedBy;
	}
	
	/**
	  * Get Title
	  */

	public String getTitle() {
		return title;
	}
	
	/**
	  * Set Title
	  */

	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	  * Get Company Name
	  */

	public String getCompanyName() {
		return companyName;
	}
	
	/**
	  * Set Company Name
	  */

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	/**
	  * Get Salary
	  */

	public String getSalary() {
		return salary;
	}
	
	/**
	  * Set Salary
	  */

	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	/**
	  * Get Description
	  */

	public String getDescription() {
		return description;
	}
	
	/**
	  * Set Description
	  */

	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	  * Get Has Applied
	  */

	public boolean getHasApplied() {
		return hasApplied;
	}
	
	/**
	  * Set Has Applied
	  */

	public void setHasApplied(boolean hasApplied) {
		this.hasApplied = hasApplied;
	}
}
