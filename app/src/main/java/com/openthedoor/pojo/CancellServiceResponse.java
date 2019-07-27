package com.openthedoor.pojo;


import com.google.gson.annotations.SerializedName;

public class CancellServiceResponse{

	@SerializedName("messages")
	private String messages;

	@SerializedName("status")
	private boolean status;

	@SerializedName("Userservicecancel")
	private Userservicecancel userservicecancel;

	public void setMessages(String messages){
		this.messages = messages;
	}

	public String getMessages(){
		return messages;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	public void setUserservicecancel(Userservicecancel userservicecancel){
		this.userservicecancel = userservicecancel;
	}

	public Userservicecancel getUserservicecancel(){
		return userservicecancel;
	}

	@Override
 	public String toString(){
		return 
			"CancellServiceResponse{" + 
			"messages = '" + messages + '\'' + 
			",status = '" + status + '\'' + 
			",userservicecancel = '" + userservicecancel + '\'' + 
			"}";
		}
}