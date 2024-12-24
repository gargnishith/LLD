problem:

to out notification to a list of users on mobile and web for a iphone added in inventory

API's

/addItem(Item)
/update()
/addNewUserToSubscribe(user)
/removeUserFromSubscription(user)


class item{
    string iD;
    double price;
    //other item configs
}

interface observable{

    +add(item);
    +updateItem();
    +addSubscription(user);
    +removeSubscription(user);
    +notify();
}

interface observer{
    
    +update()
}

class observer{
    
    string observerID;

    update(){
        cout<<"hi item send a notification"<<endl;
    }
}

class commentary implements observable{
    map<Items, int> presentInInventory;
    queue<items> toPutNotification.
    List<observers> mobileNotification, webNotification;
    string msg;

    +add(Item){
        presentInInventory[item] = 10; toPutNotification.push(Item);
        update();
    }

    +subscribe(user){
        mobileNotification.add(user); webNotification.add(user);
    }

    +unsubscribe(user){
        mobileNotification.remove(user); webNotification.remove(user);
    }

    +update(string msg){
        toPutNotification.push(item) notify();
    }

    +notify(){
        for(observers in mobileNotification, webNotification) observers.update();
    }
}

class driver{

    

}