package com.example.designpattern.CarRentalSystem;

import java.util.List;

import com.example.designpattern.CarRentalSystem.Product.Vehicle;

public class VehicleInventoryManagement {
    List<Vehicle> vehicles;
    
    VehicleInventoryManagement(List<Vehicle> vehicle){
        this.vehicles = vehicle;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
