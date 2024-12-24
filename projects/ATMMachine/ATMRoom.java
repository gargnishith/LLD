package projects.ATMMachine;

public class ATMRoom{
    static ATM atm;

    public static void main(String args[])
    {
        ATMRoom room1 = new ATMRoom();
        room1.initialize();
        room1.atm.getCurrentState();
        room1.atm.getCurrentState().insertCard(atm);
        //System.err.println("hellllllloooo");
        room1.atm.getCurrentState();
    }

    private void initialize(){
        this.atm = ATM.getATM();
    }

} 