package com.ssba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MResume
{
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("data")
    @Expose
    private MData data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MData getData() {
        return data;
    }

    public void setData(MData data) {
        this.data = data;
    }

}