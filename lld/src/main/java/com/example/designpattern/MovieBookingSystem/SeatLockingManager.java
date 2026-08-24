package com.example.designpattern.MovieBookingSystem;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.example.designpattern.MovieBookingSystem.Enums.SeatStatus;
import com.example.designpattern.MovieBookingSystem.Models.Seat;
import com.example.designpattern.MovieBookingSystem.Models.Show;

public class SeatLockingManager {
    private final Map<Show, Map<Seat, String>> showLockedSeats;
    private final ScheduledExecutorService service;
    private final long LOCK_TIME_MS;

    public SeatLockingManager(){
        showLockedSeats = new ConcurrentHashMap<>();
        service = new ScheduledThreadPoolExecutor(1);
        LOCK_TIME_MS = 500;
    }

    public boolean lockSeats(Show show, List<Seat> seats, String userId){
        List<Seat> lockedSeats = new ArrayList<>();
        try{
            List<Seat> seatsToLock = seats.stream().sorted(Comparator.comparingInt(Seat::getPos)).toList();
            for(Seat seat:seatsToLock){
                synchronized(seat){
                    if(seat.getSeatStatus()==SeatStatus.AVAILABLE){
                        seat.setSeatStatus(SeatStatus.LOCKED);
                        lockedSeats.add(seat);
                    }else{
                        rollbackSeats(lockedSeats);
                        System.out.println("Seat "+seat.getId()+" not available.");
                        return false;
                    }
                }
            }
            showLockedSeats.computeIfAbsent(show, k-> new ConcurrentHashMap<>());
            for(Seat seat:seatsToLock){
                showLockedSeats.get(show).put(seat, userId);
            }

            service.schedule(()->unlockSeats(seatsToLock, show, userId), LOCK_TIME_MS, TimeUnit.MILLISECONDS);
            return true;
        }catch(Exception e){
            rollbackSeats(lockedSeats);
            return false;
        }
    }

    private void rollbackSeats(List<Seat> seatsToLock){
        for(Seat seat:seatsToLock){
            synchronized(seat){
                seat.setSeatStatus(SeatStatus.AVAILABLE);
            }
        }
    }

    public void unlockSeats(List<Seat> seatsToLock, Show show, String userId){
        for(Seat seat:seatsToLock){
            synchronized(seat){
                if(showLockedSeats.containsKey(show) && showLockedSeats.get(show).containsKey(seat)
                    && showLockedSeats.get(show).get(seat).equals(userId)){
                        
                        showLockedSeats.get(show).remove(seat);
                        if(seat.getSeatStatus()==SeatStatus.LOCKED)
                            seat.setSeatStatus(SeatStatus.AVAILABLE);
                }
            }
        }
    }

    public void shutdown(){
        try{
            service.shutdown();
        }catch(Exception e){
            System.out.println("Exception occured while shutting down");
        }
    }
}
