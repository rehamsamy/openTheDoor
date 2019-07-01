package com.openthedoor.pojo;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class FormdataItem{

	@SerializedName("src")
	private List<Object> src;

	@SerializedName("type")
	private String type;

	@SerializedName("key")
	private String key;

	public void setSrc(List<Object> src){
		this.src = src;
	}

	public List<Object> getSrc(){
		return src;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
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
			"FormdataItem{" + 
			"src = '" + src + '\'' + 
			",type = '" + type + '\'' + 
			",key = '" + key + '\'' + 
			"}";
		}
}