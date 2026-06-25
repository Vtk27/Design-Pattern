package com.example.designpattern.CarRentalSystem;

public class User {
    String name;
    String drivingLicense;
    int userId;

    User(String name, String dL){
        this.name = name;
        this.drivingLicense = dL;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDrivingLicense() {
        return drivingLicense;
    }
    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
