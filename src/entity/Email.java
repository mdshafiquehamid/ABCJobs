/**
 * Email Java Bean Class 
 * 
 * @author samyutha
 *
 */

package entity;

/**
 * Email method extending Entity Java bean
 */

public class Email extends Entity{
	
	 private String subject;
	 private String message;
	 private String timestamp;
	 
	 private int emailID;
	 
	 /**
	  * Get Subject
	  */

	    public String getSubject() {
	        return subject;
	    }
	    
	    /**
		  * Set Subject
		  */

	    public void setSubject(String subject) {
	        this.subject = subject;
	    }
	    
	    /**
		  * Get Message
		  */

	    public String getMessage() {
	        return message;
	    }
	    
	    /**
		  * Set Message
		  */

	    public void setMessage(String message) {
	        this.message = message;
	    }
	    
	    /**
		  * Get Timestamp
		  */
	    
	    public String getTimestamp() {
	        return timestamp;
	    }
	    
	    /**
		  * Set Timestamp
		  */

	    public void setTimestamp(String timestamp) {
	        this.timestamp = timestamp;
	    }
	    
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
}
