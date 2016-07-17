package com.example.rapsk.jumpstart;

/**
 * Created by RAPSK on 7/18/2016.
 */
public class Investor {

    public int id;
    public String last_name;
    public String first_name;
    public String email_address;
    public String location;

    //lacking []project, []investments;

    public Investor(int id, String last_name, String first_name, String email_address, String location) {
        this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.email_address = email_address;
        this.location = location;
    }

    public Investor() {
    }
}
