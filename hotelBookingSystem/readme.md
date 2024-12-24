Requirements:

The hotel management system should allow guests to book rooms, check-in, and check-out.
The system should manage different types of rooms, such as single, double, deluxe, and suite.
The system should handle room availability and reservation status.
The system should allow the hotel staff to manage guest information, room assignments, and billing.
The system should support multiple payment methods, such as cash, credit card, and online payment.
The system should handle concurrent bookings and ensure data consistency.
The system should provide reporting and analytics features for hotel management.
The system should be scalable and handle a large number of rooms and guests.


Assumptions:

one user one booking 


API:

/bookRoom(Room, User)
/checkIn(user)
/checkOut(user)
/status(room)
/bill(user)
/getBookings /getFreeRooms
/payTheBill(booking)

Enum RoomTypr{"single", "double", "delux", "king"}
Enum RoomStatus{"booked", "checkedIN", "checkedOUT", "Available}

class room{

    string roomID;
    RoomStatus roomStatus
    double price;
    RoomType roomType;


    +synchronised bookRoom(){
        if(this.roomStatus==Available) this.roomStatus = Booked;  else throw exception("not available");
    }
    +clearRoom(){
        if(this.roomStatus==checkedIN) this.roomStatus = checkedOut; else throw exception("not booked yet");
    }
    +checkIN(){this.roomStatus = checkedIN} +checkOut{this.roomStatus = checkedOut}
    +currentStatus{return this.roomStatus}

}

class guest{

    string guestID;
    booking Booking;

    +bookARoom{

    }
    +checkInRoom{

    }
    +checkOutRoom{

    }
}

class booking{
    private room roomBooked;
    private guest guestWhoBooked;

    +getBooking(room, guest); +getUser(); +getRoom();
}

class invoice{
    booking Booking;
    double Price;
    
    +generateInvoice(Booking)
    +sendInvoice()
}

interface paymentStrategy{
    +paymentmethod();
}
class cardPaymentStrategy implements paymentStrategy
class cashPaymentStrategy implements paymentStrategy
class onlinePaymentStrategy implements paymentStrategy

class hotel{

    List<room> roomsInHotel;
    map<guest, booking> bookings; list<rooms> allAvailableRooms, allAvailableSingleRoom, all
    map<room,status> roomStatus;
    
    +initialize(){

    }
    +showAvailableRoomsbyType(roomType);
    +showAvaialbleAllRooms(); 
    +bookRoom(room roomToBook,user UserToBook){
        roomToBook.bookRoom(); bookings[UserToBook]=booking.getBooking(roomToBook, UserToBook);
    }
    +cancelBooking(Booking){
        bookings.remove(Booking.getUser); Booking.getRoom.clearRoom();
    }
    +checkIn(Booking){
        roomStatus[Booking.getRoom] = CheckedIn;
    }
    +checkOut(Booking){
        roomStatus.remove(Booking.getRoom);
        invoice.generateInovice(Booking);
    }
    
}

class application{
    hotelSystem = new hotel(); hotelSystem.initialize();
    guest = new guest(); hotelSystem.showAvaialbleAllRooms();
    hotelSystem.showAvailableRoomsbyType(roomType); 
    hotelSystem.bookRoom(room, guest); hotelSystem.cancelBooking(Booking);
}


