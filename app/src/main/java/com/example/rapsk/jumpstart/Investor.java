package com.example.rapsk.jumpstart;

/**
 * Created by RAPSK on 7/18/2016.
 */
public class Investor {

    public String id;
    public String last_name;
    public String first_name;
    public String email_address;
    public int paymaya_id;
    public int paypal_id;
    public Project wishlist;
    public Investment investment;
    public Location location;

    public Investor(String id, String last_name, String first_name, String email_address, int paymaya_id, int paypal_id, Project wishlist, Investment investment, Location location) {
        this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.email_address = email_address;
        this.paymaya_id = paymaya_id;
        this.paypal_id = paypal_id;
        this.wishlist = wishlist;
        this.investment = investment;
        this.location = location;
    }
    public Investor() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getPaymaya_id() {
        return paymaya_id;
    }

    public void setPaymaya_id(int paymaya_id) {
        this.paymaya_id = paymaya_id;
    }

    public int getPaypal_id() {
        return paypal_id;
    }

    public void setPaypal_id(int paypal_id) {
        this.paypal_id = paypal_id;
    }

    public Project getWishlist() {
        return wishlist;
    }

    public void setWishlist(Project wishlist) {
        this.wishlist = wishlist;
    }

    public Investment getInvestment() {
        return investment;
    }

    public void setInvestment(Investment investment) {
        this.investment = investment;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
