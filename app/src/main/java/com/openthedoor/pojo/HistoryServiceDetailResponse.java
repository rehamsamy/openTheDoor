package com.openthedoor.pojo;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class HistoryServiceDetailResponse{

	@SerializedName("userserviceinfo")
	private List<UserserviceinfoItem> userserviceinfo;

	@SerializedName("status")
	private boolean status;

	public void setUserserviceinfo(List<UserserviceinfoItem> userserviceinfo){
		this.userserviceinfo = userserviceinfo;
	}

	public List<UserserviceinfoItem> getUserserviceinfo(){
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
			"HistoryServiceDetailResponse{" + 
			"userserviceinfo = '" + userserviceinfo + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}