Requirement:

The system should allow users to view the list of movies playing in different theaters.
Users should be able to select a movie, theater, and show timing to book tickets.
The system should display the seating arrangement of the selected show and allow users to choose seats.
Users should be able to make payments and confirm their booking.
The system should handle concurrent bookings and ensure seat availability is updated in real-time.
The system should support different types of seats (e.g., normal, premium) and pricing.
The system should allow theater administrators to add, update, and remove movies, shows, and seating arrangements.
The system should be scalable to handle a large number of concurrent users and bookings.


/listOfMovies(theatre?)
/bookTicket(movie, theatre, show);
/displayTheatre(show, movie);
/payment(ticket)
/editTheatre()  // theater administrators to add, update, and remove movies, shows, and seating arrangements.

assumption:
System will be updated everyday for new movies and theatres and shows.

ENUM SEATTYPE = {normal, premium}

class Ticket{
    string TicketId;
    Movie movieToBeShown;
    Theatre theatreForMovie;
    map<seatId, seat> seatsSelected;
    bool isPaid();

    +createTicket();
    +PaymentStrategy.payTicket(ticket);
}

interface PaymentStrategy {+pay();}
class CardPaymentStrategy 

class Movie{

    string movieId;
    //movie Metadata;

}

interface Seats {
    +createSeat(int priceDecided);
    +getPrice();
    +bookSeat();
}
class PremiumSeat implements Seats{
    double Price; bool isAvailable;

    +createSeat(priceDecided);
    +getPrice();
    +bookSeat();
    +checkAvailablilty();
}
class NormalSeat implements Seats{
    double Price; bool isAvailable;

    +createSeat(priceDecided); +getPrice(); +bookSeat(); +checkAvailablilty();
}


class Show{
    map<seat, ticket> seatStatus;
    string showId;
    time startTime; time endTime;
    Movie movieToBeShown;
    Show newShow = new Show();

    +editMovieToBeShown;
    +createShow(startTime, endTime, movieToBeShown);{return newShow;}
    +getSeatStatus();{
        for(each seat in seatStatus) if(seat.checkAvailablilty()==true) return "Avialable" return "Booked"
    }
    +synchronised lockSeat(map<seatId, seat> seatsSelected);{
        for(each seatId in seatsSelected) {seatsSelected[seatId].bookSeat();}

    }
}

class Screens{
    map<>
}

singleton class Admin{
    map<theatreId, Theatre> theatreRegistered;


}

class Theatre{
    map<Movie,List<Theatre>> moviePlayingByWhichTheatre; map<seat,ticket> seatStatus;
    show currentShow; map<showId,show> showsScheduled; map<seatID, seat> seatInfo, map<movieId, movie> moviesListed;

    +getShows();
    +createTheatre();{
        //create 2D array of Seats. Allocate few of them to PremiumSeat.createSeat(100); and remianing NormalSeat.createSeat(50);
        //create 10 movies //create 4 shows for throughOut the day. //add shows in showsScheduled for theatre;
    }
    +bookShow(string showId, map<seatID, seat> seatsSelected);{
        showsScheduled[showID].lockSeat()
    }
    +showBooking(showId);{showsScheduled[showId].getSeatStatus();}
    +
}

class Application{

    movieApplication = new Application();
    map<theatreId,Theatre> theatreInfo; theatreInfo[theatreId].showBooking(showID); 
    theatreInfo[theatreId].bookShow(showId, map<seatID, seat> seatsSelected);
    
    +initialize();{
        //create some Theatres; //add them in TheatreInfo.
    }
}
