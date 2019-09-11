/**
 * Job Java Bean Class 
 * 
 * @author samyutha
 *
 */

package entity;

/**
 * Job method extending Entity Java bean
 */

public class Job extends Entity{
	
	 private String jobTitle;
	 private String companyName;
	 private String salary;
	 private String jobDescription;
	 
	 private int jobID;
	 
	 /**
	  * Get Job Title
	  */

	    public String getJobTitle() {
	        return jobTitle;
	    }
	    
	    /**
		  * Set Job Title
		  */

	    public void setJobTitle(String jobTitle) {
	        this.jobTitle = jobTitle;
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
		  * Get Job Description
		  */
	    
	    public String getJobDescription() {
	        return jobDescription;
	    }
	    
	    /**
		  * Set Job Description
		  */

	    public void setJobDescription(String jobDescription) {
	        this.jobDescription = jobDescription;
	    }
	    
	    /**
		  * Get Job Id
		  */
	    
	    public int getJobID() {
	        return jobID;
	    }
	    
	    /**
		  * Set Job Id
		  */

	    public void setJobID(int jobID) {
	        this.jobID = jobID;
	    }

}
