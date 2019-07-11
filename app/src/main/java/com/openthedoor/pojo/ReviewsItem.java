package com.openthedoor.pojo;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class ReviewsItem implements Parcelable{

	@SerializedName("notes")
	private String notes;

	@SerializedName("user_image")
	private String userImage;

	@SerializedName("user_name")
	private String userName;

	@SerializedName("active")
	private String active;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("provider_image")
	private String providerImage;

	@SerializedName("updated_at")
	private Object updatedAt;

	@SerializedName("watch")
	private String watch;

	@SerializedName("rate")
	private int rate;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("provider_id")
	private int providerId;

	@SerializedName("id")
	private int id;

	@SerializedName("provider_name")
	private String providerName;

	protected ReviewsItem(Parcel in) {
		notes = in.readString();
		userImage = in.readString();
		userName = in.readString();
		active = in.readString();
		createdAt = in.readString();
		providerImage = in.readString();
		watch = in.readString();
		rate = in.readInt();
		userId = in.readInt();
		providerId = in.readInt();
		id = in.readInt();
		providerName = in.readString();
	}

	public static final Creator<ReviewsItem> CREATOR = new Creator<ReviewsItem>() {
		@Override
		public ReviewsItem createFromParcel(Parcel in) {
			return new ReviewsItem(in);
		}

		@Override
		public ReviewsItem[] newArray(int size) {
			return new ReviewsItem[size];
		}
	};

	public void setNotes(String notes){
		this.notes = notes;
	}

	public String getNotes(){
		return notes;
	}

	public void setUserImage(String userImage){
		this.userImage = userImage;
	}

	public String getUserImage(){
		return userImage;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setActive(String active){
		this.active = active;
	}

	public String getActive(){
		return active;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setProviderImage(String providerImage){
		this.providerImage = providerImage;
	}

	public String getProviderImage(){
		return providerImage;
	}

	public void setUpdatedAt(Object updatedAt){
		this.updatedAt = updatedAt;
	}

	public Object getUpdatedAt(){
		return updatedAt;
	}

	public void setWatch(String watch){
		this.watch = watch;
	}

	public String getWatch(){
		return watch;
	}

	public void setRate(int rate){
		this.rate = rate;
	}

	public int getRate(){
		return rate;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setProviderId(int providerId){
		this.providerId = providerId;
	}

	public int getProviderId(){
		return providerId;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setProviderName(String providerName){
		this.providerName = providerName;
	}

	public String getProviderName(){
		return providerName;
	}

	@Override
 	public String toString(){
		return 
			"ReviewsItem{" + 
			"notes = '" + notes + '\'' + 
			",user_image = '" + userImage + '\'' + 
			",user_name = '" + userName + '\'' + 
			",active = '" + active + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",provider_image = '" + providerImage + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",watch = '" + watch + '\'' + 
			",rate = '" + rate + '\'' + 
			",user_id = '" + userId + '\'' + 
			",provider_id = '" + providerId + '\'' + 
			",id = '" + id + '\'' + 
			",provider_name = '" + providerName + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(notes);
		dest.writeString(userImage);
		dest.writeString(userName);
		dest.writeString(active);
		dest.writeString(createdAt);
		dest.writeString(providerImage);
		dest.writeString(watch);
		dest.writeInt(rate);
		dest.writeInt(userId);
		dest.writeInt(providerId);
		dest.writeInt(id);
		dest.writeString(providerName);
	}
}