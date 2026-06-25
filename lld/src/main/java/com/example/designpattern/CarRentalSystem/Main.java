package com.example.designpattern.CarRentalSystem;

import java.util.ArrayList;
import java.util.List;

import com.example.designpattern.CarRentalSystem.Product.Vehicle;
import com.example.designpattern.CarRentalSystem.Product.VehicleType;

public class Main {
    public static void main(String[] args){
        Location lc = new Location("hyderbad", 500001, "Hyderbad", "Telangana", "India");
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle car = new Vehicle(VehicleType.CAR);
        vehicles.add(car);
        List<Reservation> reservations = new ArrayList<>();
        Store store = new Store(reservations, vehicles, lc);
        List<Store> stores = new ArrayList<>();
        stores.add(store);

        List<User> userList = new ArrayList<>();

        //0. creates a user
        User user1 = new User("Shreyansh", "DL002942");
        userList.add(user1);

        RentalSystem rs = new RentalSystem(stores, userList);
        
        //1. selects a location and search by it
        
        Store st = rs.getNearByStore(lc);
        //

        //2. get list of vehicle in that store
        List<Vehicle> storeVehicles = st.getVehicleList(VehicleType.CAR);
        
        //3. create  a reservation 
        Reservation reservation = new Reservation(user1, storeVehicles.get(0), ReservationType.DAILY, ReservationStatus.INPROGRESS);

        //4. generate a bill
        Bill bill = new Bill(reservation);

        //5. make payment 
        Payment payment  = new Payment(bill, PaymentMode.CASH);
        payment.doPayment();


    }
}
