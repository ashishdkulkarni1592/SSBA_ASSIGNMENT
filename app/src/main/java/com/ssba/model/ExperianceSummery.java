package com.ssba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExperianceSummery {

    @SerializedName("skills_summery")
    @Expose
    private String skillsSummery;
    @SerializedName("overall_summery")
    @Expose
    private String overallSummery;

    public String getSkillsSummery() {
        return skillsSummery;
    }

    public void setSkillsSummery(String skillsSummery) {
        this.skillsSummery = skillsSummery;
    }

    public String getOverallSummery() {
        return overallSummery;
    }

    public void setOverallSummery(String overallSummery) {
        this.overallSummery = overallSummery;
    }

}
