# Book Movie Ticket

- Design and concurrency Management
- User -> Location / City -> Select Movies from list of Movies -> List of threader / list of shows -> seat selection ->
  Booking ->Payment -> Confirmation
- how to handle Concurrency
- Two user should not get the same seat in same screen and in same theatre
- Types of locks
    - Optimistic
        - Read lock
            - Allow multiple user to read the seats
        - Write Lock.
            - At the time of update , select row 30 version one -> check version and update acquire lock and update
              version 2 and release lock.
    - Pessimistic
        - read and write lock together.
        - Disadvantages
            - No one can read it , so it is wastage of resources

## Flow

## Requirements

## Objects

1. User
2. Location
3. Movie -> MovieController
4. Threat has List of Screens -> TheatreController
5. Screens
6. Shows
7. Seats
8. Booking
9. Payment
10.

## LLD

```java
import java.util.List;

class Movie {
    int movieId;
    String movieName;
    int movieDuration;
    String language;
}

// has movie
class MovieController {
    Map<City, List<Movie>> mapOfMoviesInCity;
    List<Movie> allMovies; // without city 


    // CRUD 

}

// has a screen , show  , address
class Theatre {
    int id;
    Address completeAddress;
    City city; // this can be improved
    List<Screen> screenList;
    List<Show> showList;

}

// has theatre , city 
class TheaterController {
    Map<City, List<Theatre>> cityVsTheater;
    List<Theatre> allTheatre;


}

// has Seat
class Screen {
    int screenId;
    List<Seat> seatList;
}

class Seat {
    int seatId;
    String row;
    SeatCategory seatCategory;
    int price;

}

enum SeatCategory {
    SILVER, GOLD, PLATINUM
}

// has Movie , screen 
class Show {
    int showId;
    Movie movie;
    Screen screen;
    long startTime;
    List<Integer> bookedSeatID;
}

class Address {
    City city;
    String state;
    String zipCode;
}

// has show
class Booking {
    Show show;
    List<Seat> seatList;
    Payment payment;
}

class Payment {
    int id;
    PaymentStatus paymentStatus;
}

class BookMyShowApp {
    MovieController movieController;
    TheatreController theatreController;

    BookMyShowApp(MovieController movieController, TheatreController theatreController) {
        this.movieController = movieController;
        this.theatreController = theatreController;
    }

    public void initialize() {
        Movie movie = createMovie();
        Theatre theatre = createTheatre();
    }

    private void createMovie() {
        // create movie 
        // add in movie controller that which movie available in which city.

    }

    private void createTheatre() {
        // ceate screen 
        // create shows 
        // ceate seats 

    }

}



```

