package com.openthedoor.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class AllReviewsResponse{

	@SerializedName("reviews")
	private List<ReviewsItem> reviews;

	@SerializedName("status")
	private boolean status;

	public void setReviews(List<ReviewsItem> reviews){
		this.reviews = reviews;
	}

	public List<ReviewsItem> getReviews(){
		return reviews;
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
			"AllReviewsResponse{" + 
			"reviews = '" + reviews + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}