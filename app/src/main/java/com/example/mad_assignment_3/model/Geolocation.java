package com.example.mad_assignment_3.model;

import com.google.gson.annotations.SerializedName;

public class Geolocation {
    Geolocation(double latitude, double longitude) {
        this.longitude=longitude;
        this.latitude=latitude;
    }
    @SerializedName("latitude")
    double latitude;
    @SerializedName("longitude")
    double longitude;

    public double getLatitude() { return latitude; }

    public double getLongitude(){ return longitude; }
}
