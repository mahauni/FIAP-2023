package model;

import java.util.Date;

public class User {
	private int id;
	private String name;
	private String email;
	private String telephone;
	private String passwd;
	private Date loginDate;
	
	public User(String name, String email, String telephone, String passwd) {
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.passwd = passwd;
		this.loginDate = new Date();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}	
}
