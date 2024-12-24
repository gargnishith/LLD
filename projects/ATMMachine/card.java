package projects.ATMMachine;

public class card {

    String cardId;
    String nameOnCard;
    String accountNumber;
    int currCardBalance;

    public int getBalance()
    {
        return currCardBalance;
    }

    public void changeBalance(int Amount){
        this.currCardBalance = this.currCardBalance-Amount;
    }
    
}
