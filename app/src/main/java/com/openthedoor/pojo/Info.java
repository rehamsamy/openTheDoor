package com.openthedoor.pojo;

import com.google.gson.annotations.SerializedName;


public class Info{

	@SerializedName("schema")
	private String schema;

	@SerializedName("name")
	private String name;

	@SerializedName("_postman_id")
	private String postmanId;

	public void setSchema(String schema){
		this.schema = schema;
	}

	public String getSchema(){
		return schema;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPostmanId(String postmanId){
		this.postmanId = postmanId;
	}

	public String getPostmanId(){
		return postmanId;
	}

	@Override
 	public String toString(){
		return 
			"Info{" + 
			"schema = '" + schema + '\'' + 
			",name = '" + name + '\'' + 
			",_postman_id = '" + postmanId + '\'' + 
			"}";
		}
}