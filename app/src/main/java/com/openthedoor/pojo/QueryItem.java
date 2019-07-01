package com.openthedoor.pojo;


import com.google.gson.annotations.SerializedName;


public class QueryItem{

	@SerializedName("value")
	private String value;

	@SerializedName("key")
	private String key;

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}

	public void setKey(String key){
		this.key = key;
	}

	public String getKey(){
		return key;
	}

	@Override
 	public String toString(){
		return 
			"QueryItem{" + 
			"value = '" + value + '\'' + 
			",key = '" + key + '\'' + 
			"}";
		}
}