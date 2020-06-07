package com.ssba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tools {

    @SerializedName("primary")
    @Expose
    private String primary;
    @SerializedName("Beginner")
    @Expose
    private String beginner;

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public String getBeginner() {
        return beginner;
    }

    public void setBeginner(String beginner) {
        this.beginner = beginner;
    }

}
