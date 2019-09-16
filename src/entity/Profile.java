package entity;

/**
 * 
 * @author Samyutha
 * @version 1.0
 * @description Profile Java Bean Class including all the getters and setters
 * 
 */

public class Profile {
	int userID;
	String firstName, lastName, email, city, country, companyName;
	boolean blocked;

	/**
	 * Get User ID
	 */

	public int getUserID() {
		return userID;
	}

	/**
	 * Set User ID
	 */

	public void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	 * Get First Name
	 */

	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set First Name
	 */

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Get Last Name
	 */

	public String getLastName() {
		return lastName;
	}

	/**
	 * Set Last Name
	 */

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	/**
	 * Get City
	 */

	public String getCity() {
		return city;
	}

	/**
	 * Set City
	 */

	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Get Country
	 */

	public String getCountry() {
		return country;
	}

	/**
	 * Set Country
	 */

	public void setCountry(String country) {
		this.country = country;
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
	 * Get Blocked
	 */

	public boolean isBlocked() {
		return blocked;
	}
	
	/**
	 * Set Blocked
	 */

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
}
