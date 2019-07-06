package com.openthedoor.pojo;


import com.google.gson.annotations.SerializedName;


public class FavoriteUserPlaces{

	@SerializedName("fav_plac_long")
	private String favPlacLong;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("fav_plac_address")
	private String favPlacAddress;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("fav_plac_title")
	private String favPlacTitle;

	@SerializedName("fav_plac_lat")
	private String favPlacLat;

	@SerializedName("id")
	private int id;

	public void setFavPlacLong(String favPlacLong){
		this.favPlacLong = favPlacLong;
	}

	public String getFavPlacLong(){
		return favPlacLong;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setFavPlacAddress(String favPlacAddress){
		this.favPlacAddress = favPlacAddress;
	}

	public String getFavPlacAddress(){
		return favPlacAddress;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setFavPlacTitle(String favPlacTitle){
		this.favPlacTitle = favPlacTitle;
	}

	public String getFavPlacTitle(){
		return favPlacTitle;
	}

	public void setFavPlacLat(String favPlacLat){
		this.favPlacLat = favPlacLat;
	}

	public String getFavPlacLat(){
		return favPlacLat;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"FavoriteUserPlaces{" + 
			"fav_plac_long = '" + favPlacLong + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",user_id = '" + userId + '\'' + 
			",fav_plac_address = '" + favPlacAddress + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",fav_plac_title = '" + favPlacTitle + '\'' + 
			",fav_plac_lat = '" + favPlacLat + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}