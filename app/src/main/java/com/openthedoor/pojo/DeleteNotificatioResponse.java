package com.openthedoor.pojo;

public class DeleteNotificatioResponse{
	private String successMsg;

	public void setSuccessMsg(String successMsg){
		this.successMsg = successMsg;
	}

	public String getSuccessMsg(){
		return successMsg;
	}

	@Override
 	public String toString(){
		return 
			"DeleteNotificatioResponse{" + 
			"successMsg = '" + successMsg + '\'' + 
			"}";
		}
}
