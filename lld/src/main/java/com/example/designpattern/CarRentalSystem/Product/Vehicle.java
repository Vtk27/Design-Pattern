package com.example.designpattern.CarRentalSystem.Product;

import java.util.Date;

public class Vehicle {
    int vehicleId;
    String vehicleNumber;
    VehicleType vechicleType;
    String companyName;
    String modelName;
    int kmDriver;
    Date manufacturingDate;
    int dailyRentalCost;
    int hourlyRentalCost;
    Status status;

    public Vehicle(VehicleType vehicleType){
        this.vechicleType = vehicleType;
    }

    public int getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public VehicleType getVechicleType() {
        return vechicleType;
    }
    public void setVechicleType(VehicleType vechicleType) {
        this.vechicleType = vechicleType;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getModelName() {
        return modelName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public int getKmDriver() {
        return kmDriver;
    }
    public void setKmDriver(int kmDriver) {
        this.kmDriver = kmDriver;
    }
    public Date getManufacturingDate() {
        return manufacturingDate;
    }
    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }
    public int getDailyRentalCost() {
        return dailyRentalCost;
    }
    public void setDailyRentalCost(int dailyRentalCost) {
        this.dailyRentalCost = dailyRentalCost;
    }
    public int getHourlyRentalCost() {
        return hourlyRentalCost;
    }
    public void setHourlyRentalCost(int hourlyRentalCost) {
        this.hourlyRentalCost = hourlyRentalCost;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    
}
