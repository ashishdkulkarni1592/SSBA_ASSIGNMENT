package com.ssba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OtherSummery {

    @SerializedName("apps")
    @Expose
    private String apps;
    @SerializedName("summery")
    @Expose
    private Summery summery;

    public String getApps() {
        return apps;
    }

    public void setApps(String apps) {
        this.apps = apps;
    }

    public Summery getSummery() {
        return summery;
    }

    public void setSummery(Summery summery) {
        this.summery = summery;
    }

}
