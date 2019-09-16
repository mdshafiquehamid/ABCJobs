package entity;

/**
 * 
 * @author Samyutha
 * @version 1.0
 * @description Message Java Bean Class including all the getters and setters
 * 
 */

public class Message extends Entity{
	
	 private String subject;
	 private String message;
	 private String timestamp;
	 
	 private int messageID;
	 
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
		  * Get Message ID
		  */
	    
	    public int getMessageID() {
	        return messageID;
	    }
	    
	    /**
		  * Set Message ID
		  */

	    public void setMessageID(int messageID) {
	        this.messageID = messageID;
	    }

}
