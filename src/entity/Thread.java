package entity;

/**
 * 
 * @author Samyutha
 * @version 1.0
 * @description Thread Java Bean Class including all the getters and setters
 * 
 */

public class Thread extends Entity{
	
	 private String threadSubject;
	 private String threadMessage;
	 private String timestamp;
	 
	 private int threadID;
	 
	 /**
	  * Get Thread Subject
	  */

	    public String getThreadSubject() {
	        return threadSubject;
	    }
	    
	    /**
		  * Set Thread Subject
		  */

	    public void setThreadSubject(String threadSubject) {
	        this.threadSubject = threadSubject;
	    }
	    
	    /**
		  * Get Thread Message
		  */

	    public String getThreadMessage() {
	        return threadMessage;
	    }
	    
	    /**
		  * Set Thread Message
		  */

	    public void setThreadMessage(String threadMessage) {
	        this.threadMessage = threadMessage;
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
		  * Get Thread ID
		  */
	    
	    public int getThreadID() {
	        return threadID;
	    }
	    
	    /**
		  * Set Thread ID
		  */

	    public void setThreadID(int threadID) {
	        this.threadID = threadID;
	    }

}
