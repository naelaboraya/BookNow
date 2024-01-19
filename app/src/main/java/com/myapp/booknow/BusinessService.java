package com.myapp.booknow;

public class BusinessService {
    private String serviceId;
    private String businessId;
    private String name;
    private String description;
    private int duration;


    BusinessService(){

    }
    BusinessService(String id ,String businessId, String name , String description, int duration){
        this.serviceId = id;
        this.businessId = businessId;
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


}
