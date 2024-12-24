Requirements:

Here there are n given meeting rooms. 
Book a meeting in any meeting room at given interval(starting time, end time). 
Send notifications to all person who are invited for meeting.
You should use calender for tracking date and time. 
Also history of all the meetings which are booked and meeting room.
Write an API for client who will give date and time and API should return meeting room with booked scheduled time. 
client should also query for history of last 20 booked meetings.
Is meeting room available?

Assumption:
By word last i mean the meetings which got expired or attended. no Future Meeting.

class Calendar{
    User calenderOwner;
    map<meetingId, meeting> meetingsInCalndar;
    +getCalander(user);

}

class User{
    Calander userCalander;
    string userId; map<meetingId, Meeting> meetingsBooked; List<Meeting> last20Meetings;
    
    +getBookings();{
        userCalender.getBookings();
    } +getLast20Bookings();{return last20Meetings;} 
}

class Room{
    string roomID;
    int capacity;
    map<bookingId, Booking> bookings

    +synchronised bookRoom(); +checkAvialable();
}

class RoomManager{
    map<roomId, Room> Rooms;

    +showBookings(user);
}




