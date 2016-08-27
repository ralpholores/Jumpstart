package com.example.rapsk.jumpstart.Models;

/**
 * Created by cicct on 8/6/2016.
 */
public class Investment {

    public Project project;
    public int disbursed_fund;
    public int ROI;

    public Investment() {
    }

    public Investment(Project project, int disbursed_fund, int ROI) {

        this.project = project;
        this.disbursed_fund = disbursed_fund;
        this.ROI = ROI;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getDisbursed_fund() {
        return disbursed_fund;
    }

    public void setDisbursed_fund(int disbursed_fund) {
        this.disbursed_fund = disbursed_fund;
    }

    public int getROI() {
        return ROI;
    }

    public void setROI(int ROI) {
        this.ROI = ROI;
    }
}
