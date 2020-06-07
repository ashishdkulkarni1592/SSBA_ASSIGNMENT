package com.ssba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MData
{

        @SerializedName("experiance_summery")
        @Expose
        private ExperianceSummery experianceSummery;
        @SerializedName("technical_summery")
        @Expose
        private TechnicalSummery technicalSummery;
        @SerializedName("other_summery")
        @Expose
        private OtherSummery otherSummery;
        @SerializedName("educational_summery")
        @Expose
        private EducationalSummery educationalSummery;
        @SerializedName("personal_details")
        @Expose
        private PersonalDetails personalDetails;
        @SerializedName("work_experiance")
        @Expose
        private List<WorkExperiance> workExperiance = null;

        public ExperianceSummery getExperianceSummery() {
            return experianceSummery;
        }

        public void setExperianceSummery(ExperianceSummery experianceSummery) {
            this.experianceSummery = experianceSummery;
        }

        public TechnicalSummery getTechnicalSummery() {
            return technicalSummery;
        }

        public void setTechnicalSummery(TechnicalSummery technicalSummery) {
            this.technicalSummery = technicalSummery;
        }

        public OtherSummery getOtherSummery() {
            return otherSummery;
        }

        public void setOtherSummery(OtherSummery otherSummery) {
            this.otherSummery = otherSummery;
        }

        public EducationalSummery getEducationalSummery() {
            return educationalSummery;
        }

        public void setEducationalSummery(EducationalSummery educationalSummery) {
            this.educationalSummery = educationalSummery;
        }

        public PersonalDetails getPersonalDetails() {
            return personalDetails;
        }

        public void setPersonalDetails(PersonalDetails personalDetails) {
            this.personalDetails = personalDetails;
        }

        public List<WorkExperiance> getWorkExperiance() {
            return workExperiance;
        }

        public void setWorkExperiance(List<WorkExperiance> workExperiance) {
            this.workExperiance = workExperiance;
        }
}
