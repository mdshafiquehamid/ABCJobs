/**
 * Users Java Bean Class 
 * 
 * @author samyutha
 *
 */

package entity;

/**
 * Users method extending Entity Java bean
 */

public class Users extends Entity{
	private String password; 
	private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String blockNo;
    private String street;
    private String unitNo;
    private String postalCode;
    private String city;
    private String country;
    
    private int userRoleID;
    
    /**
	  * Get Password
	  */
    
    public String getPassword() {
        return password;
    }
    
    /**
	  * Set Password
	  */

    public void setPassword(String password) {
        this.password = password;
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
	  * Get Mobile
	  */

    public String getMobile() {
        return mobile;
    }
    
    /**
	  * Set Mobile
	  */

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    /**
	  * Get Block No
	  */

    public String getBlockNo() {
        return blockNo;
    }
    
    /**
	  * Set Block No
	  */

    public void setBlockNo(String blockNo) {
        this.blockNo = blockNo;
    }
    
    /**
	  * Get Street
	  */
    
    public String getStreet() {
        return street;
    }
    
    /**
	  * Set Street
	  */
   
    public void setStreet(String street) {
        this.street = street;
    }
    
    /**
	  * Get Unit No
	  */
    
    public String getUnitNo() {
        return unitNo;
    }
    
    /**
	  * Set Unit No
	  */

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }
    
    /**
	  * Get Postal Code
	  */
    
    public String getPostalCode() {
        return postalCode;
    }
    
    /**
	  * Set Postal Code
	  */

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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
	  * Get User Role ID
	  */
    
    public int getUserRoleID() {
        return userRoleID;
    }
    
    /**
	  * Set User Role ID
	  */

    public void setUserRoleID(int userRoleID) {
        this.userRoleID = userRoleID;
    }

}
