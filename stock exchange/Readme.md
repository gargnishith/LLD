Requirements:

The online stock brokerage system should allow users to create and manage their trading accounts.
Users should be able to buy and sell stocks, as well as view their portfolio and transaction history.
The system should provide real-time stock quotes and market data to users.
The system should handle order placement, execution, and settlement processes.
The system should enforce various business rules and validations, such as checking account balances and stock availability.
The system should handle concurrent user requests and ensure data consistency and integrity.
The system should be scalable and able to handle a large number of users and transactions.
The system should be secure and protect sensitive user information.


/registerUser(user);
/profile(user);
/buy(units);
/sell(units);
/portfolio(user);
/txnHistory(user);
/realTimeInfo(stock?);
should handle order placement, execution, and settlement processes.
checking account balances and stock availability

/totalTradesOfDayStockWise(list<stock>?)
/totalTradesOfDayUserWise(list<user>?)

class Stock{
    string stockId;
    double currentPrice;
    double 
}


class User{
    map<stockID, stock> stocksInvolved;
}