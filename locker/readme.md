Requirements:

Implement Amazon Locker. It's a service where users can choose a locker in building full of lockers and get their parcel delivered there. They get an OTP to access that locker. If they don't pick up their item in 7 days, item is returned and locker should be vacated. System should know which lockers are available to be booked, and if items are not picked locker should become available again. User can pick any locker from available lockers in nearby location.

assumption: no bifurcation in slots

/getFreeLocker();   //User can pick any locker from available lockers in nearby location. 
outputType: List<Locker> getFreeLocker()||getFreeLocker(): List<Locker>
/getFreeSlot();
/getItemLocations(item?);
/submitItemToFreeSlotOfLocker(item);
/freeLocker(LockerId); 
/generateOTP();
/checkOTP();
/checkTimeOutItems() //If they don't pick up their item in 7 days, item is returned 

class ItemMetadata{
    time createdAt; 
    Location returnLocation;
    //Metadata like item height, weight, area
}

class Item{
    string ItemId;
    User toBePickedBy;
    Locker locker; ItemMetadata meta;

    +getSlot();{
        if(this.meta.size==small) return new Slot; else return new BigSlot;
    }
}

interface Slot{
    bookSlot(); 
    freeSlot();
}

class SmallSlot implements Slot{
    bool isAvailable;
    Item itemContained;
    int OTP;
    Booking booking;
    Slot newSlot = new SmallSlot();

    synchronise bookSlot(); +removeSlot(); +setOTP(int generatedOTP){this.otp = generatedOTP}; 
    verifyOTP(EnterOTP);{if True removeSlot(); else throw error;} +checkExpiry()
}
class BigSlot implements Slot{
    bool isAvailable;
    Item itemContained;
    int OTP;
    Booking booking;
    Slot newSlot = new BigSlot();

    +synchronise bookSlot(){this.booking = Booking.getBooking();}; +removeSlot(); +setOTP(int generatedOTP){this.otp = generatedOTP}; +verifyOTP(EnterOTP); 
    +checkExpiry();
}

class OTP{
    time endTime; int value;

    +getNewOTP();
}
class Booking{
    date submittedAt;
    Slot slotForBooking;

    +getBooking()
}

class SlotManager{
    Item itemToPark; map<slotId, slot> slotsToManage; map<slot, otp> otps;  priority_queue<Booking> bookingInvolved;
    map<slot,Expired>
    map<slot, Booking>
    SlotManager manager = new SlotManager;
    +createSlot(){return newSlot;} +generateOTP(freeSlot){
        fleeSlot.setOTP(OTP.getNewOTP())
    }; 
    +placeItem(slotId);  
    expireSlots()
    updateExpireSlots()
    checkExpiry()
    {
        timer.schedule(new TimerTask() {
        @Override
        public void run() {
        // Your database code here
        }
        }, 2*60*1000);
        // Since Java-8
        timer.schedule(() -> /* your database code here */, 2*60*1000);
    }
}

class Locker{
    map<slotId, slot> slotsInLocker; stack<slot> freeSlots; map<item, slot> itemDetails;
    Location locationPlaced;
    SlotManager slotManager;


    +getFreeSlot(item?);{return freeSlots.top(); freeSlots.pop();} +createLocker(locationPlaced);
}

singleton class LockerManager(){
    map<LockerId, Locker> lockers;
    map<Location, List<LockerID>> locationWiseLockers; 

    +createManager();{
        create lockers; 
    }
    +getLockerNearLocation(Location); return locationWiseLockers[location];
    +getLockerStatus();
    +updateLockers(){
        for each locker in lockersconfiguraton:
            for each Slot in lockeroncifguration[locker];
                slot.updateExpireSlots(); 
    }
}

class application{
    LockerManager manager = LockerManager.createManager();
    map<LockerId,Locker> nearLockers = application.manager.getLockerNearLocation(location); 
    
    application.manager.lockers[lockerId].getFreeSlot(Item) 
    cin<<selectedLockerId<<item;
    Slot freeSlot = nearLockers[selectedLockerId].getFreeSlot(item); 
    int otp = nearLockers[selectedLockerId].slotManager.generateOTP(freeSlot);
    nearLockers[selectedLockerId].slotManager.slotsToManage[freeSlot].bookSlot(otp); 
    nearLockers[selectedLockerId].slotManager.slotsToManage[freeSlot].setOTP(otp);

    cin<<userToUseLocker cin<<slotIDInThatLocker cin<<EnterOTP
    manager.lockers[userToUseLocker].slotManager.slotsToManage[slotIDInThatLocker].verifyOTP(EnterOTP);


    application.manager.lockers[lockerId].slotsInLocker[application.manager.getLockerNearLocation(Location)]

    application.manager.lockers[lockerID].

    if(system.time.) application.manager 

}



synchrinise


