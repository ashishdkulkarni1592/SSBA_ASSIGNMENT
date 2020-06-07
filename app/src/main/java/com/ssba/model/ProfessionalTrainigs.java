package com.ssba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfessionalTrainigs
{
    @SerializedName("primary_training")
    @Expose
    private String primaryTraining;
    @SerializedName("secondary_training")
    @Expose
    private String secondaryTraining;

    public String getPrimaryTraining() {
        return primaryTraining;
    }

    public void setPrimaryTraining(String primaryTraining) {
        this.primaryTraining = primaryTraining;
    }

    public String getSecondaryTraining() {
        return secondaryTraining;
    }

    public void setSecondaryTraining(String secondaryTraining) {
        this.secondaryTraining = secondaryTraining;
    }

}

