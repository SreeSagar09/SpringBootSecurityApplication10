package com.app.dto;

import com.app.model.Users;

public class UsersDTO {
	private Integer userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String fullName;
	private String address;
	private String createDate;
	private String updatedDate;
	private String role;
	
	public UsersDTO() {
		super();
	}

	public UsersDTO(Integer userId, String userName, String firstName, String lastName, String fullName,
			String address, String createDate, String updatedDate, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.address = address;
		this.createDate = createDate;
		this.updatedDate = updatedDate;
		this.role = role;
	}
	
	public UsersDTO(UsersDTOBuilder object) {
		this.userId = object.userId;
		this.userName = object.userName;
		this.firstName = object.firstName;
		this.lastName = object.lastName;
		this.fullName = object.fullName;
		this.address = object.address;
		this.createDate = object.createDate;
		this.updatedDate = object.updatedDate;
		this.role = object.role;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public static class UsersDTOBuilder {
		private Integer userId;
		private String userName;
		private String firstName;
		private String lastName;
		private String fullName;
		private String address;
		private String createDate;
		private String updatedDate;
		private String role;
		
		public UsersDTOBuilder(Users object) {
			this.userId = object.getUserId();
			this.userName = object.getUserName();
			this.firstName = object.getFirstName();
			this.lastName  = object.getLastName();
			if(object.getLastName() != null && !object.getLastName().trim().isEmpty()) {
				this.fullName = object.getFirstName()+" "+object.getLastName();
			}else {
				this.fullName = object.getFirstName();
			}
			this.address = object.getAddress();
			this.role = object.getRole();
		}
		
		public UsersDTOBuilder setCreateDate(String createDate) {
			this.createDate = createDate;
			return this;
		}
		
		public UsersDTOBuilder setUpdatedDate(String updatedDate) {
			this.updatedDate = updatedDate;
			return this;
		}
		
		public UsersDTO build() {
			return new UsersDTO(this);
		}
		
	}
}
