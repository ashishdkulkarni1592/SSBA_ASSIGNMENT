package com.ssba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorkExperiance {

    @SerializedName("project_name")
    @Expose
    private String projectName;
    @SerializedName("organization")
    @Expose
    private String organization;
    @SerializedName("team_size")
    @Expose
    private String teamSize;
    @SerializedName("project_description")
    @Expose
    private ProjectDescription projectDescription;
    @SerializedName("roles")
    @Expose
    private String roles;
    @SerializedName("contribution")
    @Expose
    private String contribution;
    @SerializedName("achivements")
    @Expose
    private String achivements;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(String teamSize) {
        this.teamSize = teamSize;
    }

    public ProjectDescription getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(ProjectDescription projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getContribution() {
        return contribution;
    }

    public void setContribution(String contribution) {
        this.contribution = contribution;
    }

    public String getAchivements() {
        return achivements;
    }

    public void setAchivements(String achivements) {
        this.achivements = achivements;
    }

}
