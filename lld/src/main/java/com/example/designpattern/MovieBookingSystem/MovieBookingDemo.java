package com.example.designpattern.MovieBookingSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.designpattern.MovieBookingSystem.Enums.SeatStatus;
import com.example.designpattern.MovieBookingSystem.Models.Booking;
import com.example.designpattern.MovieBookingSystem.Models.City;
import com.example.designpattern.MovieBookingSystem.Models.Movie;
import com.example.designpattern.MovieBookingSystem.Models.Screen;
import com.example.designpattern.MovieBookingSystem.Models.Seat;
import com.example.designpattern.MovieBookingSystem.Models.Show;
import com.example.designpattern.MovieBookingSystem.Models.Theatre;

public class MovieBookingDemo {
    public static void main(String[] args){
        MovieBookingService service = new MovieBookingService();

        City nyc = service.addCity("City 1", "New York");
        City la = service.addCity("City 2", "Los Angeles");
        
        Movie matrix = new Movie("M1", "The Matrix", 120);
        Movie avengers = new Movie("M2", "Avengers: Endgame", 170);
        service.addMovie(matrix);
        service.addMovie(avengers);

        // Add Seats for a Screen
        Screen screen1 = new Screen("S1");

        Show matrixShow = service.addShow("show1", matrix, screen1, LocalDateTime.now().plusHours(2));
        Show avengersShow = service.addShow("show2", avengers, screen1, LocalDateTime.now().plusHours(5));

        for (int i = 1; i <= 10; i++) {
            matrixShow.addSeat(new Seat("A" + i, i, 100));
            avengersShow.addSeat(new Seat("B" + i, 10+i,100));
        }

        List<Show> shows = new ArrayList<>(List.of(matrixShow, avengersShow));
        Theatre amcNYC = service.addTheatre("Theatre1", "AMC Time Square Theatre", nyc.getId(), shows);



        //Alice booking tickets
        String cityName = "New York";
        System.out.println("User selected city->"+cityName);
        List<Show> showsAvailable = service.getShowByCity(cityName);
        Set<Movie> moviesAvailable = service.getMoviesFromShow(showsAvailable);
        System.out.println("Shows Available in City->"+moviesAvailable.stream().map(Movie::getName).toList());
        //User select movie from given movies option
        String movieTitle = "Avengers: Endgame";
        System.out.println("Movie selected in City->"+movieTitle);

        Movie avengersMovie = service.getMovie(movieTitle).get();

        List<Show> availableShows = service.showsWithMovie(avengersMovie, showsAvailable);
        if (availableShows.isEmpty()) {
            System.out.println("No shows found for " + movieTitle + " in " + cityName);
            return;
        }

        Show selectedShow = availableShows.get(0);//Alice selects first show
        List<Seat> availableSeats = selectedShow.getSeats().stream()
                .filter(seat -> seat.getSeatStatus() == SeatStatus.AVAILABLE)
                .toList();
        System.out.printf("Available seats for '%s' at %s: %s%n",
                selectedShow.getMovie().getName(),
                selectedShow.getStartTime(),
                availableSeats.stream().map(Seat::getId).collect(Collectors.toList()));

        // 3. Select seats
        List<Seat> desiredSeats = List.of(availableSeats.get(2), availableSeats.get(3));
        System.out.println("Alice selects seats: " + desiredSeats.stream().map(Seat::getId).toList());

        // 4. Book Tickets
        Optional<Booking> bookingOpt = service.bookTickets("Alice", selectedShow, desiredSeats);

        if(bookingOpt.isPresent()){
            Booking booking = bookingOpt.get();
            System.out.println("\n--- Booking Successful! ---");
            System.out.println("Booking ID: " + booking.getId());
            System.out.println("User: " + booking.getUserName());
            System.out.println("Movie: " + booking.getShow().getMovie().getName());
            System.out.println("Seats: " + booking.getBookedSeats().stream().map(Seat::getId).toList());
            System.out.println("Total Amount: $" + booking.getTotalAmount());
            System.out.println("Payment Status: " + booking.getPayment().getPaymentStatus());
        }else {
            System.out.println("Booking failed.");
        }
        System.out.println("\nSeat status after Alice's booking:");
        desiredSeats.forEach(seat -> System.out.printf("Seat %s status: %s%n", seat.getId(), seat.getSeatStatus()));

        //Shutdown scheduled service thread
        service.shutdown();
    }
}
