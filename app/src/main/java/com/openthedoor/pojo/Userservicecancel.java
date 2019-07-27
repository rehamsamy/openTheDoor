package com.openthedoor.pojo;


import com.google.gson.annotations.SerializedName;


public class Userservicecancel{

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("reson_for_cancel")
	private String resonForCancel;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("user_service_id")
	private String userServiceId;

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setResonForCancel(String resonForCancel){
		this.resonForCancel = resonForCancel;
	}

	public String getResonForCancel(){
		return resonForCancel;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setUserServiceId(String userServiceId){
		this.userServiceId = userServiceId;
	}

	public String getUserServiceId(){
		return userServiceId;
	}

	@Override
 	public String toString(){
		return 
			"Userservicecancel{" + 
			"updated_at = '" + updatedAt + '\'' + 
			",user_id = '" + userId + '\'' + 
			",reson_for_cancel = '" + resonForCancel + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",user_service_id = '" + userServiceId + '\'' + 
			"}";
		}
}