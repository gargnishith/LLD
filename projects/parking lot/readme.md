Parking Lot

API's required

getFreeSlots();
postBookingAAvailableSlot(Vehicle ID);
postRemovingVehicle(Vehicle ID);
getTicket(Vehicle ID);
getPaymentStatus(Ticket ID);
getTotalProfit();

Class Spot{
    bool isAvailable;
    string spotID;

    + bookTheSlot();
    + releaseTheSlot();
}

Class Vehicle{
    string VehicleID;
    string userID;
    string parkTime;
    string pickupTime;

    +createVehicle(userID);
}

class ticket{
    int price;
    vehicle Vehicle;

    +generateTicket(Vehicle);{
        ticket t1 =  new ticket();
        t1.price = 100;
        return t1;
    }
    
    +payTheTicket() {
        int priceToPay = this.price;

        //Code for Payment gateway
    }
}

Class manager{
    Map<Vehicle, Spot> bookedSpots;
    Queue<Spot> availableSpots;
    List<ticket> tickets;
    int ;

    +getManager();
    +getFreeFlot();{totalRevenue
        return availableSpots.top();
    }
    +book(vehicle);{
        vehicle.parkTime = systime;
        bookedSpots[vehicle] = availableSpots.top(); availableSpots.pop();
    }
    +remove(vehicle);{
        vehicle.removeTime = systime; ticket ticketToPay = ticket.generate(vehicle); ticketToPay.payTheTicket(); 
        totalRevenue+=ticketToPay.price; 
        availableSpots.push(bookedSpots[vehicle]); bookedSpots.remove(vehicle);
    } 
    +getRevenue(){
        return totalRevenue;
    }
}

class main{
    Floor floorObj;
    floorObj = Floor.getManager();
    floorObj.getFreeSlot();
    floorObj.book(Vehicle);
    floorObj.remove(Vehicle);
    floorObj.getRevenue;

    initialize()
    {
        this.floorObj = Floor.getFloor();
    }
}

