package com.openthedoor.pojo;



import java.util.List;

import com.google.gson.annotations.SerializedName;


public class ResponsePojo{

    @SerializedName("item")
    private List<ItemItem> item;

    @SerializedName("info")
    private Info info;

    public void setItem(List<ItemItem> item){
        this.item = item;
    }

    public List<ItemItem> getItem(){
        return item;
    }

    public void setInfo(Info info){
        this.info = info;
    }

    public Info getInfo(){
        return info;
    }

    @Override
    public String toString(){
        return
                "Response{" +
                        "item = '" + item + '\'' +
                        ",info = '" + info + '\'' +
                        "}";
    }
}