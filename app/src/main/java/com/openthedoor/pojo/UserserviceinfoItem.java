package com.openthedoor.pojo;


import com.google.gson.annotations.SerializedName;

public class UserserviceinfoItem{

	@SerializedName("provider_price_per_hour")
	private int providerPricePerHour;

	@SerializedName("notes")
	private String notes;

	@SerializedName("bounce")
	private String bounce;

	@SerializedName("provider_minutes_to_arrive")
	private int providerMinutesToArrive;

	@SerializedName("user_name")
	private String userName;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("provider_hour_to_finish")
	private int providerHourToFinish;

	@SerializedName("total")
	private int total;

	@SerializedName("coupon_id")
	private int couponId;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("rat_count")
	private int ratCount;

	@SerializedName("cost_of_service_provider")
	private int costOfServiceProvider;

	@SerializedName("service_id")
	private int serviceId;

	@SerializedName("id")
	private int id;

	@SerializedName("provider_name")
	private String providerName;

	@SerializedName("payment_method")
	private String paymentMethod;

	@SerializedName("service_name_en")
	private String serviceNameEn;

	@SerializedName("service_name_ar")
	private String serviceNameAr;

	@SerializedName("rat_sum")
	private String ratSum;

	@SerializedName("coupon_value")
	private Object couponValue;

	@SerializedName("schedule_time")
	private String scheduleTime;

	@SerializedName("watch")
	private int watch;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("provider_id")
	private int providerId;

	@SerializedName("status")
	private String status;

	public void setProviderPricePerHour(int providerPricePerHour){
		this.providerPricePerHour = providerPricePerHour;
	}

	public int getProviderPricePerHour(){
		return providerPricePerHour;
	}

	public void setNotes(String notes){
		this.notes = notes;
	}

	public String getNotes(){
		return notes;
	}

	public void setBounce(String bounce){
		this.bounce = bounce;
	}

	public String getBounce(){
		return bounce;
	}

	public void setProviderMinutesToArrive(int providerMinutesToArrive){
		this.providerMinutesToArrive = providerMinutesToArrive;
	}

	public int getProviderMinutesToArrive(){
		return providerMinutesToArrive;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setProviderHourToFinish(int providerHourToFinish){
		this.providerHourToFinish = providerHourToFinish;
	}

	public int getProviderHourToFinish(){
		return providerHourToFinish;
	}

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setCouponId(int couponId){
		this.couponId = couponId;
	}

	public int getCouponId(){
		return couponId;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setRatCount(int ratCount){
		this.ratCount = ratCount;
	}

	public int getRatCount(){
		return ratCount;
	}

	public void setCostOfServiceProvider(int costOfServiceProvider){
		this.costOfServiceProvider = costOfServiceProvider;
	}

	public int getCostOfServiceProvider(){
		return costOfServiceProvider;
	}

	public void setServiceId(int serviceId){
		this.serviceId = serviceId;
	}

	public int getServiceId(){
		return serviceId;
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

	public void setPaymentMethod(String paymentMethod){
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentMethod(){
		return paymentMethod;
	}

	public void setServiceNameEn(String serviceNameEn){
		this.serviceNameEn = serviceNameEn;
	}

	public String getServiceNameEn(){
		return serviceNameEn;
	}

	public void setServiceNameAr(String serviceNameAr){
		this.serviceNameAr = serviceNameAr;
	}

	public String getServiceNameAr(){
		return serviceNameAr;
	}

	public void setRatSum(String ratSum){
		this.ratSum = ratSum;
	}

	public String getRatSum(){
		return ratSum;
	}

	public void setCouponValue(Object couponValue){
		this.couponValue = couponValue;
	}

	public Object getCouponValue(){
		return couponValue;
	}

	public void setScheduleTime(String scheduleTime){
		this.scheduleTime = scheduleTime;
	}

	public String getScheduleTime(){
		return scheduleTime;
	}

	public void setWatch(int watch){
		this.watch = watch;
	}

	public int getWatch(){
		return watch;
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

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"UserserviceinfoItem{" + 
			"provider_price_per_hour = '" + providerPricePerHour + '\'' + 
			",notes = '" + notes + '\'' + 
			",bounce = '" + bounce + '\'' + 
			",provider_minutes_to_arrive = '" + providerMinutesToArrive + '\'' + 
			",user_name = '" + userName + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",provider_hour_to_finish = '" + providerHourToFinish + '\'' + 
			",total = '" + total + '\'' + 
			",coupon_id = '" + couponId + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",rat_count = '" + ratCount + '\'' + 
			",cost_of_service_provider = '" + costOfServiceProvider + '\'' + 
			",service_id = '" + serviceId + '\'' + 
			",id = '" + id + '\'' + 
			",provider_name = '" + providerName + '\'' + 
			",payment_method = '" + paymentMethod + '\'' + 
			",service_name_en = '" + serviceNameEn + '\'' + 
			",service_name_ar = '" + serviceNameAr + '\'' + 
			",rat_sum = '" + ratSum + '\'' + 
			",coupon_value = '" + couponValue + '\'' + 
			",schedule_time = '" + scheduleTime + '\'' + 
			",watch = '" + watch + '\'' + 
			",user_id = '" + userId + '\'' + 
			",provider_id = '" + providerId + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}