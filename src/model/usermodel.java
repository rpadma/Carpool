package model;

import java.sql.Date;

public class usermodel extends basemodel {

	Long id;
	String email;
	String ciperpassword;
	String salt;
	Date createdate;
	String role;
	
	
	
	public usermodel() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCiperpassword() {
		return ciperpassword;
	}
	public void setCiperpassword(String ciperpassword) {
		this.ciperpassword = ciperpassword;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
