package com.openthedoor.pojo;


import com.google.gson.annotations.SerializedName;


public class UserResponse{

	@SerializedName("user")
	private User user;

	@SerializedName("status")
	private boolean status;

	@SerializedName("token")
	private String token;

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"UserResponse{" + 
			"user = '" + user + '\'' + 
			",status = '" + status + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}