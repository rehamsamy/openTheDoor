package com.openthedoor.pojo;


import com.google.gson.annotations.SerializedName;

public class HistoryResponse{

	@SerializedName("userserviceinfo")
	private Userserviceinfo userserviceinfo;

	@SerializedName("status")
	private boolean status;

	public void setUserserviceinfo(Userserviceinfo userserviceinfo){
		this.userserviceinfo = userserviceinfo;
	}

	public Userserviceinfo getUserserviceinfo(){
		return userserviceinfo;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"HistoryResponse{" + 
			"userserviceinfo = '" + userserviceinfo + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}