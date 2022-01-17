package com.example.mad_assignment_3;

public class Company {
    private String name, location, year;
    public Company() {
    }
    public Company(String name, String location, String year) {
        this.name = name;
        this.location = location;
        this.year = year;
    }
    public String getName() {
        return name;
    }
    public void getName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
}
