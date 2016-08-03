package com.example.rapsk.jumpstart;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by RAPSK on 7/17/2016.
 */
@IgnoreExtraProperties
public class SME {

    public String id;
    public String company_name;
    public String ads_url;
    public String email_address;
    public String[] location;
    public String[] project_list;
    public String description;

    public SME(String id, String company_name, String[] project_list,String ads_url, String email_address, String description) {
        this.id = id;
        this.company_name = company_name;
        this.ads_url = ads_url;
        this.email_address = email_address;
//        this.location = location;
        this.project_list = project_list;
        this.description = description;
    }

    public SME() {

            // default constuctor for calling the DataSnapshot.getValue(User.class);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getAds_url() {
        return ads_url;
    }

    public void setAds_url(String ads_url) {
        this.ads_url = ads_url;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String[] getLocation() {
        return location;
    }

    public void setLocation(String[] location) {
        this.location = location;
    }

    public String[] getProject_list() {
        return project_list;
    }

    public void setProject_list(String[] project_list) {
        this.project_list = project_list;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
