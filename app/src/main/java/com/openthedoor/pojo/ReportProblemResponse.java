package com.openthedoor.pojo;


import com.google.gson.annotations.SerializedName;
public class ReportProblemResponse{

	@SerializedName("Reportproblem")
	private Reportproblem reportproblem;

	@SerializedName("messages")
	private String messages;

	@SerializedName("status")
	private boolean status;

	public void setReportproblem(Reportproblem reportproblem){
		this.reportproblem = reportproblem;
	}

	public Reportproblem getReportproblem(){
		return reportproblem;
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
			"ReportProblemResponse{" + 
			"reportproblem = '" + reportproblem + '\'' + 
			",messages = '" + messages + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}