package com.openthedoor.pojo;


import com.google.gson.annotations.SerializedName;


public class AddReviewResponse{

	@SerializedName("SuccessMsg")
	private String successMsg;

	@SerializedName("Review")
	private Review review;

	@SerializedName("status")
	private boolean status;

	public void setSuccessMsg(String successMsg){
		this.successMsg = successMsg;
	}

	public String getSuccessMsg(){
		return successMsg;
	}

	public void setReview(Review review){
		this.review = review;
	}

	public Review getReview(){
		return review;
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
			"AddReviewResponse{" + 
			"successMsg = '" + successMsg + '\'' + 
			",review = '" + review + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}