package com.example.rapsk.jumpstart.Home.entities;

import java.util.ArrayList;

/**
 * Created by gvg on 8/8/2016.
 */
public class SME{

//    private String mName;
//    private String mGenre;
//    private String mSummary;
//    private int    mImageId;
//
//    /**
//     * Creates a new instance of a {@link SME}.
//     */
//    public SME() {
//    }
//
//    /**
//     * Creates a new instance of a {@link SME}.    }
//
//     */
//    public SME(String name, String genre, String summary, int imageId) {
//        mName = name;
//        mGenre = genre;
//        mSummary = summary;
//        mImageId = imageId;
//    }
//
//    /**
//     * Gets the SME name.
//     */
//    public String getName() {
//        return mName;
//    }
//
//    /**
//     * Sets a SME name.
//     */
//    public SME setName(String name) {
//        mName = name;
//        return this;
//    }
//
//    /**
//     * Gets the SME genre.
//     */
//    public String getGenre() {
//        return mGenre;
//    }
//
//    /**
//     * Sets the SME genre.
//     */
//    public SME setGenre(String genre) {
//        mGenre = genre;
//        return this;
//    }
//
//    /**
//     * Gets the SME summary.
//     */
//    public String getSummary() {
//        return mSummary;
//    }
//
//    /**
//     * Sets the SME summary.
//     */
//    public SME setSummary(String summary) {
//        mSummary = summary;
//        return this;
//    }
//
//    /**
//     * Gets the cover image id of the SME.
//     */
//    public int getImageId() {
//        return mImageId;
//    }
//
//    /**
//     * Sets the cover image id of the SME.
//     */
//    public SME setImageId(int imageId) {
//        mImageId = imageId;
//        return this;
//    }

    public String id;
    public String company_name;
    public String ads_url;
    public String email_address;
    public ArrayList<Project> project_list;
    public String description;
    public Location location;
    private int    mImageId;

    public SME(String id, String company_name, String ads_url, String email_address, ArrayList<Project> project_list, String description, Location location) {
        this.id = id;
        this.company_name = company_name;
        this.ads_url = ads_url;
        this.email_address = email_address;
        this.project_list = project_list;
        this.description = description;
        this.location = location;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Project> getProject_list() {
        return project_list;
    }

    public void setProject_list(ArrayList<Project> project_list) {
        this.project_list = project_list;
    }
}