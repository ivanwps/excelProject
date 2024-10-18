package org.main;

public class Plan {
    private String benefit;
    private String coverage;
    private String category;
    private String planName;
    private String coverageValue;

    // Constructor
    public Plan(String benefit, String coverage, String category, String planName, String coverageValue) {
        this.benefit = benefit;
        this.coverage = coverage;
        this.category = category;
        this.planName = planName;
        this.coverageValue = coverageValue;
    }

    // Getters and setters
    public String getBenefit() { return benefit; }
    public void setBenefit(String benefit) { this.benefit = benefit; }

    public String getCoverage() { return coverage; }
    public void setCoverage(String coverage) { this.coverage = coverage; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getPlanName() { return planName; }
    public void setPlanName(String planName) { this.planName = planName; }

    public String getCoverageValue() { return coverageValue; }
    public void setCoverageValue(String coverageValue) { this.coverageValue = coverageValue; }

    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20s%-30s%-20s", benefit, coverage, category, planName, coverageValue);
    }
}
