package com.example.rapsk.jumpstart.Models;

/**
 * Created by cicct on 8/6/2016.
 */
public class Location {

    public double longLocation;
    public double lat;
    public String address;

    public Location(double longLocation, double lat, String address) {
        this.longLocation = longLocation;
        this.lat = lat;
        this.address = address;
    }

    public Location() {
    }

    public double getLongLocation() {
        return longLocation;
    }

    public void setLongLocation(double longLocation) {
        this.longLocation = longLocation;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
