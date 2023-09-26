package com.project.dto;

public class UserDTO {

	private int userId;
	private String name;
	private String email;
	private String password;
	private String address;

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", address=" + address + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserDTO(int userId, String name, String email, String password, String address) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
	}

	public UserDTO(String name, String email, String password, String address) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
	}

	public UserDTO(String email) {
		super();
		this.email = email;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
