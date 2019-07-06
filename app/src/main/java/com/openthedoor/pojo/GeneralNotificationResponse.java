package com.openthedoor.pojo;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class GeneralNotificationResponse{

	@SerializedName("Generalnotfication")
	private List<GeneralnotficationItem> generalnotfication;

	@SerializedName("status")
	private boolean status;

	public void setGeneralnotfication(List<GeneralnotficationItem> generalnotfication){
		this.generalnotfication = generalnotfication;
	}

	public List<GeneralnotficationItem> getGeneralnotfication(){
		return generalnotfication;
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
			"GeneralNotificationResponse{" + 
			"generalnotfication = '" + generalnotfication + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}