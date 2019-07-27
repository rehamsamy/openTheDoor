package com.openthedoor.pojo;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Userserviceinfo{

	@SerializedName("canceled")
	private List<Object> canceled;

	@SerializedName("current")
	private List<UserserviceinfoItem> current;

	@SerializedName("inprocess")
	private List<Object> inprocess;

	@SerializedName("scheduled")
	private List<Object> scheduled;

	@SerializedName("completed")
	private List<Object> completed;

	public void setCanceled(List<Object> canceled){
		this.canceled = canceled;
	}

	public List<Object> getCanceled(){
		return canceled;
	}

	public void setCurrent(List<UserserviceinfoItem> current){
		this.current = current;
	}

	public List<UserserviceinfoItem> getCurrent(){
		return current;
	}

	public void setInprocess(List<Object> inprocess){
		this.inprocess = inprocess;
	}

	public List<Object> getInprocess(){
		return inprocess;
	}

	public void setScheduled(List<Object> scheduled){
		this.scheduled = scheduled;
	}

	public List<Object> getScheduled(){
		return scheduled;
	}

	public void setCompleted(List<Object> completed){
		this.completed = completed;
	}

	public List<Object> getCompleted(){
		return completed;
	}

	@Override
 	public String toString(){
		return 
			"Userserviceinfo{" + 
			"canceled = '" + canceled + '\'' + 
			",current = '" + current + '\'' + 
			",inprocess = '" + inprocess + '\'' + 
			",scheduled = '" + scheduled + '\'' + 
			",completed = '" + completed + '\'' + 
			"}";
		}
}