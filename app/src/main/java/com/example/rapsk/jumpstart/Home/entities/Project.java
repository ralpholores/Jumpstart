package com.example.rapsk.jumpstart.Home.entities;

/**
 * Created by RAPSK on 7/31/2016.
 */
public class Project {

    public int id;
    public String name;
    public String description;
    public String ads_url;
    public int needed_fund;
    public String project_category;
    public int wishlist_counter;
    public int received_funds;
    public Milestones milestones;
    public int progress;
    public double start_date;
    public double end_date;
    public int sme_id;
    //logo


    public Project(int id, String name, String description, String ads_url, int needed_fund, String project_category, int wishlist_counter, int received_funds, Milestones milestones, int progress, double start_date, double end_date, int sme_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ads_url = ads_url;
        this.needed_fund = needed_fund;
        this.project_category = project_category;
        this.wishlist_counter = wishlist_counter;
        this.received_funds = received_funds;
        this.milestones = milestones;
        this.progress = progress;
        this.start_date = start_date;
        this.end_date = end_date;
        this.sme_id = sme_id;
        this.milestones = milestones;
    }

    public Project() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAds_url() {
        return ads_url;
    }

    public void setAds_url(String ads_url) {
        this.ads_url = ads_url;
    }

    public int getNeeded_fund() {
        return needed_fund;
    }

    public void setNeeded_fund(int needed_fund) {
        this.needed_fund = needed_fund;
    }

    public String getProject_category() {
        return project_category;
    }

    public void setProject_category(String project_category) {
        this.project_category = project_category;
    }

    public int getWishlist_counter() {
        return wishlist_counter;
    }

    public void setWishlist_counter(int wishlist_counter) {
        this.wishlist_counter = wishlist_counter;
    }

    public int getReceived_funds() {
        return received_funds;
    }

    public void setReceived_funds(int received_funds) {
        this.received_funds = received_funds;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public double getStart_date() {
        return start_date;
    }

    public void setStart_date(double start_date) {
        this.start_date = start_date;
    }

    public double getEnd_date() {
        return end_date;
    }

    public void setEnd_date(double end_date) {
        this.end_date = end_date;
    }

    public int getSme_id() {
        return sme_id;
    }

    public void setSme_id(int sme_id) {
        this.sme_id = sme_id;
    }

    public Milestones getMilestones() {
        return milestones;
    }

    public void setMilestones(Milestones milestones) {
        this.milestones = milestones;
    }
}