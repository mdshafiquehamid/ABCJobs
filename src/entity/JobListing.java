package entity;

public class JobListing {
	int jobId, userId, applicantCount;
	String listedBy, title, companyName, salary, description;
	boolean hasApplied;

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getApplicantCount() {
		return applicantCount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setApplicantCount(int applicantCount) {
		this.applicantCount = applicantCount;
	}

	public String getListedBy() {
		return listedBy;
	}

	public void setListedBy(String listedBy) {
		this.listedBy = listedBy;
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

	public boolean getHasApplied() {
		return hasApplied;
	}

	public void setHasApplied(boolean hasApplied) {
		this.hasApplied = hasApplied;
	}
}
