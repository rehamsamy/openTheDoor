package com.openthedoor.pojo;


import com.google.gson.annotations.SerializedName;


public class GeneralnotficationItem{

	@SerializedName("not_title_ar")
	private String notTitleAr;

	@SerializedName("not_link")
	private String notLink;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("not_title_en")
	private String notTitleEn;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	public void setNotTitleAr(String notTitleAr){
		this.notTitleAr = notTitleAr;
	}

	public String getNotTitleAr(){
		return notTitleAr;
	}

	public void setNotLink(String notLink){
		this.notLink = notLink;
	}

	public String getNotLink(){
		return notLink;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setNotTitleEn(String notTitleEn){
		this.notTitleEn = notTitleEn;
	}

	public String getNotTitleEn(){
		return notTitleEn;
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
			"GeneralnotficationItem{" + 
			"not_title_ar = '" + notTitleAr + '\'' + 
			",not_link = '" + notLink + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",not_title_en = '" + notTitleEn + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}