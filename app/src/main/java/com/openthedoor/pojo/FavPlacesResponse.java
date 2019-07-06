package com.openthedoor.pojo;


import com.google.gson.annotations.SerializedName;


public class FavPlacesResponse{

	@SerializedName("FavoriteUserPlaces")
	private FavoriteUserPlaces favoriteUserPlaces;

	@SerializedName("SuccessMsg")
	private String successMsg;

	@SerializedName("status")
	private boolean status;

	public void setFavoriteUserPlaces(FavoriteUserPlaces favoriteUserPlaces){
		this.favoriteUserPlaces = favoriteUserPlaces;
	}

	public FavoriteUserPlaces getFavoriteUserPlaces(){
		return favoriteUserPlaces;
	}

	public void setSuccessMsg(String successMsg){
		this.successMsg = successMsg;
	}

	public String getSuccessMsg(){
		return successMsg;
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
			"FavPlacesResponse{" + 
			"favoriteUserPlaces = '" + favoriteUserPlaces + '\'' + 
			",successMsg = '" + successMsg + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}