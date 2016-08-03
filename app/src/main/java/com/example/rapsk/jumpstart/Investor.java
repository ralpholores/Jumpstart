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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
