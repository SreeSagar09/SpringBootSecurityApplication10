package com.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "raw_password")
	private String rawPassword;
	
	@Column(name = "enc_password")
	private String encPassword;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "created_date")
	private Date createDate;
	
	@Column(name = "updated_date")
	private Date updatedDate;
	
	@Column(name = "role")
	private String role;

	public Users() {
		super();
	}

	public Users(Integer userId, String userName, String rawPassword, String encPassword, String firstName,
			String lastName, String address, Date createDate, Date updatedDate, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.rawPassword = rawPassword;
		this.encPassword = encPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.createDate = createDate;
		this.updatedDate = updatedDate;
		this.role = role;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRawPassword() {
		return rawPassword;
	}

	public void setRawPassword(String rawPassword) {
		this.rawPassword = rawPassword;
	}

	public String getEncPassword() {
		return encPassword;
	}

	public void setEncPassword(String encPassword) {
		this.encPassword = encPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", rawPassword=" + rawPassword + ", encPassword="
				+ encPassword + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", createDate=" + createDate + ", updatedDate=" + updatedDate + ", role=" + role + "]";
	}

	@Override
	public boolean equals(Object object) {
		if(object != null && object instanceof Users) {
			return this.userId.equals(((Users)object).getUserId());
		}
		return false;
	}
	
}