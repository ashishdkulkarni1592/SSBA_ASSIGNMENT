package com.ssba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Summery {

    @SerializedName("health_namo")
    @Expose
    private String healthNamo;
    @SerializedName("field_foster")
    @Expose
    private String fieldFoster;
    @SerializedName("bxp")
    @Expose
    private String bxp;
    @SerializedName("premium_care")
    @Expose
    private String premiumCare;

    public String getHealthNamo() {
        return healthNamo;
    }

    public void setHealthNamo(String healthNamo) {
        this.healthNamo = healthNamo;
    }

    public String getFieldFoster() {
        return fieldFoster;
    }

    public void setFieldFoster(String fieldFoster) {
        this.fieldFoster = fieldFoster;
    }

    public String getBxp() {
        return bxp;
    }

    public void setBxp(String bxp) {
        this.bxp = bxp;
    }

    public String getPremiumCare() {
        return premiumCare;
    }

    public void setPremiumCare(String premiumCare) {
        this.premiumCare = premiumCare;
    }

}
