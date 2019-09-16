package entity;

/**
 * 
 * @author Samyutha
 * @version 1.0
 * @description User Experience Java Bean Class including all the getters and setters
 * 
 */

public class UserExperience extends Entity {
	
	 private String education;
	 private String companyName;
	 private String workExperience;
	 private String skills;
	 
	 private int uxID;
	 
	 /**
	  * Get Education
	  */

	    public String getEducation() {
	        return education;
	    }
	    
	    /**
		  * Set Education
		  */

	    public void setEducation(String education) {
	        this.education = education;
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
		  * Get Work Experience
		  */
	    
	    public String getWorkExperience() {
	        return workExperience;
	    }
	    
	    /**
		  * Set Work Experience
		  */

	    public void setWorkExperience(String workExperience) {
	        this.workExperience = workExperience;
	    }
	    
	    /**
		  * Get Skills
		  */
	    
	    public String getSkills() {
	        return skills;
	    }
	    
	    /**
		  * Set Skills
		  */

	    public void setSkills(String skills) {
	        this.skills = skills;
	    }
	    
	    /**
		  * Get Ux ID
		  */
	    
	    public int getUxID() {
	        return uxID;
	    }
	    
	    /**
		  * Set Ux ID
		  */

	    public void setUxID(int uxID) {
	        this.uxID = uxID;
	    }
	}
