package entity;

/**
 * 
 * @author Samyutha
 * @version 1.0
 * @description Entity Java Bean Class including all the getters and setters
 * 
 */

public class Entity {
	  private int userID = -1;
	  
	  /**
	   * Get User ID
	   */

	    public int getuserID() {
	        return userID;
	    }
	    
	    /**
		   * Set User ID
		   */

	    public void setuserID(int userID) {
	        this.userID = userID;
	    }

}
