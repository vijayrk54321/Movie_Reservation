import java.util.Scanner;

class Movie {
    String title;
    String[] seats;
    boolean[] availability;

    Movie(String title, int numSeats) {
        this.title = title;
        seats = new String[numSeats];
        availability = new boolean[numSeats];
        for (int i = 0; i < numSeats; i++) {
            seats[i] = "Seat " + (i + 1);
            availability[i] = true;
        }
    }

    void displaySeats() {
        System.out.println("Available seats for " + title + ":");
        for (int i = 0; i < seats.length; i++) {
            if (availability[i]) {
                System.out.println(seats[i]);
            }
        }
    }

    boolean bookSeat(int seatNumber) {
        if (seatNumber < 1 || seatNumber > seats.length) {
            System.out.println("Invalid seat number.");
            return false;
        }
        if (!availability[seatNumber - 1]) {
            System.out.println("Seat " + seatNumber + " is already booked.");
            return false;
        }
        availability[seatNumber - 1] = false;
        System.out.println("Seat " + seatNumber + " booked successfully.");
        return true;
    }
}

class ReservationSystem {
    Movie[] movies;
    Scanner scanner;

    ReservationSystem() {
        scanner = new Scanner(System.in);
        movies = new Movie[3];
        movies[0] = new Movie("The Godfather", 10);
        movies[1] = new Movie("Inception", 8);
        movies[2] = new Movie("The Shawshank Redemption", 12);
    }

    void displayMovies() {
        System.out.println("Available Movies:");
        for (Movie movie : movies) {
            System.out.println(movie.title);
        }
    }

    void bookTicket() {
        displayMovies();
        System.out.print("Enter the movie title: ");
        String movieTitle = scanner.nextLine();
        Movie selectedMovie = null;
        for (Movie movie : movies) {
            if (movie.title.equalsIgnoreCase(movieTitle)) {
                selectedMovie = movie;
                break;
            }
        }
        if (selectedMovie == null) {
            System.out.println("Movie not found.");
            return;
        }
        selectedMovie.displaySeats();
        System.out.print("Enter the seat number: ");
        int seatNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        selectedMovie.bookSeat(seatNumber);
    }
}

public class Main {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();
        reservationSystem.bookTicket();
    }
}

