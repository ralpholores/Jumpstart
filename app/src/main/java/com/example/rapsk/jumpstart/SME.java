package com.example.rapsk.jumpstart;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by RAPSK on 7/17/2016.
 */
@IgnoreExtraProperties
public class SME {

    public int id;
    public String company_name;
    public String ads_url;
    public String email_address;
    public String[] location;
    public String[] project_list;
    public String description;

    public SME(int id, String company_name, String[] project_list,String ads_url, String email_address, String description) {
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




}
