package com.example.designpattern.CarRentalSystem;

import java.util.List;

import com.example.designpattern.CarRentalSystem.Product.Vehicle;
import com.example.designpattern.CarRentalSystem.Product.VehicleType;

public class Store {
    int storeId;
    VehicleInventoryManagement vehicleInventoryManagement;
    Location location;
    List<Reservation> reservations; 

    Store(List<Reservation> reservations, List<Vehicle> vehicles, Location location){
        this.vehicleInventoryManagement = new VehicleInventoryManagement(vehicles);
        this.reservations = reservations;
        this.location = location;
    }

    public List<Vehicle> getVehicleList(VehicleType vehicleType){
        //filter vehicle based on type and return
        return vehicleInventoryManagement.getVehicles();
    }

    
}