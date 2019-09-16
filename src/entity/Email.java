package entity;

/**
 * 
 * @author Samyutha
 * @version 1.0
 * @description Email Java Bean Class including all the getters and setters
 * 
 */

public class Email {
	 
	 private int emailID;
	 private String email; 
	 
	    /**
		  * Get Email ID
		  */
	    
	    public int getEmailID() {
	        return emailID;
	    }
	    
	    /**
		  * Set Email ID
		  */
	    
	    public void setEmailID(int emailID) {
	        this.emailID = emailID;
	    }
	    
	    /**
		  * Get Email
		  */

		public String getEmail() {
			return email;
		}
		
		/**
		  * Set Email 
		  */

		public void setEmail(String email) {
			this.email = email;
		}
	        
}
