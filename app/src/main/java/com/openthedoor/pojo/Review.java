package com.openthedoor.pojo;


import com.google.gson.annotations.SerializedName;


public class Review{

	@SerializedName("notes")
	private String notes;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("watch")
	private String watch;

	@SerializedName("rate")
	private String rate;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("active")
	private String active;

	@SerializedName("provider_id")
	private String providerId;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	public void setNotes(String notes){
		this.notes = notes;
	}

	public String getNotes(){
		return notes;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setWatch(String watch){
		this.watch = watch;
	}

	public String getWatch(){
		return watch;
	}

	public void setRate(String rate){
		this.rate = rate;
	}

	public String getRate(){
		return rate;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setActive(String active){
		this.active = active;
	}

	public String getActive(){
		return active;
	}

	public void setProviderId(String providerId){
		this.providerId = providerId;
	}

	public String getProviderId(){
		return providerId;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
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
			"Review{" + 
			"notes = '" + notes + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",watch = '" + watch + '\'' + 
			",rate = '" + rate + '\'' + 
			",user_id = '" + userId + '\'' + 
			",active = '" + active + '\'' + 
			",provider_id = '" + providerId + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}