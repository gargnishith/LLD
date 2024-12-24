package projects.ATMMachine;

import projects.ATMMachine.ATMStates.ATMState;
import projects.ATMMachine.ATMStates.idleState;

public class ATM {
    
    private static ATM atmobj = new ATM();
    ATMState currenState;

    private int currBalance;
    private int hundNote;
    private int twoNote;
    private int fiveNote;

    public int getBalance()
    {
        return currBalance;
    }

    public void setState(ATMState NewState)
    {
        this.currenState = NewState;
    }

    public static ATM getATM()
    {
        atmobj.setState(new idleState()); 
        return atmobj;
    }

    public ATMState getCurrentState()
    {
        String s = currenState.stateName(); System.out.println(s);
        return currenState;
    }

}
