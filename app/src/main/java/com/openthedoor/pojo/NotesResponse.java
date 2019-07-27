package com.openthedoor.pojo;


import com.google.gson.annotations.SerializedName;

public class NotesResponse{

	@SerializedName("providernotes")
	private Providernotes providernotes;

	@SerializedName("messages")
	private String messages;

	@SerializedName("status")
	private boolean status;

	public void setProvidernotes(Providernotes providernotes){
		this.providernotes = providernotes;
	}

	public Providernotes getProvidernotes(){
		return providernotes;
	}

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

	@Override
 	public String toString(){
		return 
			"NotesResponse{" + 
			"providernotes = '" + providernotes + '\'' + 
			",messages = '" + messages + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}