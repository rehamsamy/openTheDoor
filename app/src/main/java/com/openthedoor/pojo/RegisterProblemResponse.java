package com.openthedoor.pojo;


import com.google.gson.annotations.SerializedName;


public class RegisterProblemResponse{

	@SerializedName("messages")
	private Messages messages;

	@SerializedName("status")
	private boolean status;

	public void setMessages(Messages messages){
		this.messages = messages;
	}

	public Messages getMessages(){
		return messages;
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
			"RegisterProblemResponse{" + 
			"messages = '" + messages + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}