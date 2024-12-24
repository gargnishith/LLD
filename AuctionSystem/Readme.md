Requirements

The online auction system should allow users to register and log in to their accounts.
Users should be able to create new auction listings with details such as item name, description, starting price, and auction duration.
Users should be able to browse and search for auction listings based on various criteria (e.g., item name, category, price range).
Users should be able to place bids on active auction listings.
The system should automatically update the current highest bid and notify the bidders accordingly.
The auction should end when the specified duration is reached, and the highest bidder should be declared the winner.
The system should handle concurrent access to auction listings and ensure data consistency.
The system should be extensible to accommodate future enhancements and new features.

Assumptions: 

price always increase 
before start auction list of items to be auctioned will be ready.

Non fucntional Requirement:

concurrent access to auction listings

API's:

/registerUser(user)
/logIn(user)
/addItemToAuction(user, item)
/getItems() -- filters
/placeBid(amount)
/notifyAndUpdateTheRoom() -- update highest current price going on and inform others about the increase.
/timeOutBid()
/getCurrentStatusOfAllListing


class item{

    string itemID;
    user userAdded;
    double basePrice;
    double AuctionPrice;
    user userSoldTo
    time timeoutinSec;

    +updatePrice();
    +soldTo(user);
}

class user{

    string userID;
    List<item> ItemsAdded;
    bid currentBid;

    +addItem(item)
    +register()
    +login()
    +raise(bid currentBid);
    +placeBid(item){
        item.set
    }
    +updateBid(Bid updatedBid){
        currentBid = updatedBid;
    }
}

class bid{
    item currentItem; double currentPrice; user currentWinner; time toEndBid;
    List<users> user;
    room auctionRoom;

    +getBid(item){
        currentBid  = new bid(); currentBid.currentPrice = item.basePrice; currentBid.currentItem = item
        currentBid.currentWinner = null; return currentBid;
    }
    +synchronised change(user user, double newAmount){
        this.currentWinner = user; this.currentPrice = newAmount;
        auctionRoom.notify();
    }

}

class room{

    List<user> candidates;
    bid currentBid; 
    List<items> itemsTobeAuctioned; map<item,bid> itemstatus;

    +leaveRoom();
    +update(user, bid, newAmount){
        bid.change(user, newAmount);
    }
    +initialize(){
        candidates = new List<users>(10);
        itemsTobeAuctioned  = new List<item>(10);
       // itemStatus of itemsTobeAuctioned to initialize with null bid object;
    }
    +notify(){
        for(candidate:candidates) candidate.currentBid = this.currentBid;
    }
    +getCurrentStatus(item) {return itemstatus[item];}
    +getListing(){
        //return by traversing map itemStatus;
    } 
}

class application{

    list<user> activeUsers;
    room auctionRoom  = new room(); auctionRoom.initialize();
    for(iteminList:itemToBeAuctioned)
    {
        currBid = new Bid(itemInList); auctionRoom.currentBid = currBid;
        while(currBid.timeoutinSec--) auctionRoom.update(user, bid, newAmount);
    }
    auctionRoom.getCurrentStatus; auctionRoom.getCurrentStatus(item);

    application.register(user); application.addNew(item, user);

    +register(user) {activeUsers.push(user);}
    +addNew(item, user);
}



need to check if i can take params more in function/API's by myself or as some compulsion not to use other than mentioned in requirements.
how to implement Users should be able to browse and search for auction listings based on various criteria (e.g., item name, category, price range).
