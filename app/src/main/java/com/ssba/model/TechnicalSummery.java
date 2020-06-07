package com.ssba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TechnicalSummery
{
    @SerializedName("domain")
    @Expose
    private String domain;
    @SerializedName("programming_languages")
    @Expose
    private String programmingLanguages;
    @SerializedName("operating_system")
    @Expose
    private String operatingSystem;
    @SerializedName("tools")
    @Expose
    private Tools tools;
    @SerializedName("professional_trainigs")
    @Expose
    private ProfessionalTrainigs professionalTrainigs;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(String programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Tools getTools() {
        return tools;
    }

    public void setTools(Tools tools) {
        this.tools = tools;
    }

    public ProfessionalTrainigs getProfessionalTrainigs() {
        return professionalTrainigs;
    }

    public void setProfessionalTrainigs(ProfessionalTrainigs professionalTrainigs) {
        this.professionalTrainigs = professionalTrainigs;
    }
}
