package com.ssba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EducationalSummery
{

    @SerializedName("post_graduation")
    @Expose
    private String postGraduation;
    @SerializedName("bachelor_education")
    @Expose
    private String bachelorEducation;
    @SerializedName("other")
    @Expose
    private String other;

    public String getPostGraduation() {
        return postGraduation;
    }

    public void setPostGraduation(String postGraduation) {
        this.postGraduation = postGraduation;
    }

    public String getBachelorEducation() {
        return bachelorEducation;
    }

    public void setBachelorEducation(String bachelorEducation) {
        this.bachelorEducation = bachelorEducation;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

}
