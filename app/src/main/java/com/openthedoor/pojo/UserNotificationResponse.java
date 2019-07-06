package com.openthedoor.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class UserNotificationResponse{

	@SerializedName("Notfication")
	private List<NotficationItem> notfication;

	@SerializedName("status")
	private boolean status;

	public void setNotfication(List<NotficationItem> notfication){
		this.notfication = notfication;
	}

	public List<NotficationItem> getNotfication(){
		return notfication;
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
			"UserNotificationResponse{" + 
			"notfication = '" + notfication + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}