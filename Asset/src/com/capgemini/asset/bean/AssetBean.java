package com.capgemini.asset.bean;

public class AssetBean {
	String userNameId,password,userType;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserNameId() {
		return userNameId;
	}

	public void setUsername(String username) {
		this.userNameId = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
