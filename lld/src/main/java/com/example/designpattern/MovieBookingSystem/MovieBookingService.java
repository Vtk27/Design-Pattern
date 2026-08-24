package com.example.designpattern.MovieBookingSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.example.designpattern.MovieBookingSystem.Models.Booking;
import com.example.designpattern.MovieBookingSystem.Models.City;
import com.example.designpattern.MovieBookingSystem.Models.Movie;
import com.example.designpattern.MovieBookingSystem.Models.Screen;
import com.example.designpattern.MovieBookingSystem.Models.Seat;
import com.example.designpattern.MovieBookingSystem.Models.Show;
import com.example.designpattern.MovieBookingSystem.Models.Theatre;

public class MovieBookingService {
    private final Map<String, City> cities;
    private final Map<String, Theatre> theatres;
    private final Map<String, Movie> movies;
    private final Map<String, Show> shows;

    private final SeatLockingManager seatLockManager;
    private final BookingManager bookingManager;

    public MovieBookingService() {
        this.cities = new ConcurrentHashMap<>();
        this.theatres = new ConcurrentHashMap<>();
        this.movies = new ConcurrentHashMap<>();
        this.shows = new ConcurrentHashMap<>();

        this.seatLockManager = new SeatLockingManager();
        this.bookingManager = new BookingManager(seatLockManager);
    }

     public BookingManager getBookingManager() {
        return bookingManager;
    }

    // --- Data Management Methods ---
    public City addCity(String id, String name) {
        City city = new City(id, name);
        cities.put(city.getId(), city);
        return city;
    }

    public Theatre addTheatre(String id, String name, String cityId, List<Show> shows) {
        City city = cities.get(cityId);
        Theatre theatre = new Theatre(id, name, city, shows);
        theatres.put(theatre.getId(), theatre);
        return theatre;
    }

    public void addMovie(Movie movie) {
        this.movies.put(movie.getId(), movie);
    }

    public Show addShow(String id, Movie movie, Screen screen, LocalDateTime startTime) {
        Show show = new Show(id, screen, movie, startTime);
        shows.put(show.getId(), show);
        return show;
    }

    public Optional<Booking> bookTickets(String userId, Show show, List<Seat> desiredSeats) {
        return bookingManager.createBooking(show, desiredSeats, userId);
    }

    // --- Search Functionality ---
    // public List<Show> findShows(String movieTitle, String cityName) {
    //     List<Show> result = new ArrayList<>();
    //     shows.values().stream()
    //         .filter(show -> show.getMovie().getName().equalsIgnoreCase(movieTitle))
    //         .filter(show -> {
    //             Theatre cinema = findTheatreForShow(show);
    //             return cinema != null && cinema.getCity().getName().equalsIgnoreCase(cityName);
    //         })
    //         .forEach(result::add);
    //     return result;
    // }

    // private Theatre findTheatreForShow(Show show) {
    //     // This is inefficient. In a real system, shows would have a direct link to the cinema.
    //     // For this example, we traverse the cinema list.
    //     return theatres.values().stream()
    //             .filter(theatre -> theatre.getScreens().contains(show.getScreen()))
    //             .findFirst()
    //             .orElse(null);
    // }

    public List<Show> getShowByCity(String cityName){
        List<Show> showsInCity = new ArrayList<>();
        theatres.values().stream().filter(theatre->theatre.getCity().getName().equals(cityName))
                .forEach(theatre->theatre.getShows().forEach(show->showsInCity.add(show)));
        return showsInCity;
    }

    public Set<Movie> getMoviesFromShow(List<Show> shows){
        HashSet<Movie> movies = new HashSet<>();
        shows.forEach((show)->movies.add(show.getMovie()));
        return movies;
    }

    public List<Show> showsWithMovie(Movie movie, List<Show> shows){
        return shows.stream().filter(show->show.getMovie().equals(movie)).toList();
    }

    public Optional<Movie> getMovie(String movieName){
        for(String id:movies.keySet()){
            if(movies.get(id).getName().equals(movieName)) return Optional.of(movies.get(id));
        }
        return Optional.empty();
    }
    public void shutdown() {
        this.seatLockManager.shutdown();
        System.out.println("MovieTicketBookingSystem has been shut down.");
    }
}
