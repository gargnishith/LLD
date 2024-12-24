problem:

need platform to give permission to airline

1) to land
2) to parkOnGate
3) to goInQueueForFlying
4) to fly


/getLand(); /getParkingAvailableGates; /postInQueueforFlying;


class plane{

}

class gates{
    string gateID;
    bool isValid;
    plane planeParked;

    +generateGates(int noOfReqGates);
    +bookGate() {this.isValid = false;}
    +freeGate() {this.isValid = true;}
}

class airport{
    map<plane, gates> m1;
    queue<gates> availableGates;
    queue<plane> waitingToLand, waitingToFly;

    main{
        airportSystem = new airport();
        airportSystem.initialize();
        if(airportSystem.getFreeGate()==false) waitingToLand;
        airportSystem.park(plane);
        airportSystem.fly(plane)
    }

    void initialize(){
        gates.generateGates(10);
    }

    getFreeGate(){ availableGates.top(); }

    park(plane){
        m1[plane] = getFreeGate();
        m1[plane].bookGate(); availableGates.pop();
    }

    fly(plane){
        gateAcquired = m1[plane]; m1.remove(plane); availableGates.push(gateAcquired); gateAcquired.freeGate();
    }
}

how to check if no landing or flying space not available? control to check that waiting List again and again by airline system or ATS?

