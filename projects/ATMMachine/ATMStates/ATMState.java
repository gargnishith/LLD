package projects.ATMMachine.ATMStates;

import projects.ATMMachine.ATM;
import projects.ATMMachine.card;

public abstract class ATMState {
    
    public void insertCard(ATM atm){

    }

    public void checkCash(){

    }
    
    public void releaseCash(){

    }

    public String stateName(){
        return "<> State";
    }
}

