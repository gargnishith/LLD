Requirements:

The system should allow users to create accounts and manage their profile information.
Users should be able to create groups and add other users to the groups.
Users should be able to add expenses within a group, specifying the amount, description, and participants.
The system should automatically split the expenses among the participants based on their share.
Users should be able to view their individual balances with other users and settle up the balances.
The system should support different split methods, such as equal split, percentage split, and exact amounts.
Users should be able to view their transaction history and group expenses.
The system should handle concurrent transactions and ensure data consistency.


Assumptions:



APIs:
/register(user)
/profile(user)
/createGroup(list<user>, group)
/addUserToGroup(User, group)
/addExpense(expense) // expense will consist of specifying the amount, description, and participants.
/viewBalance()
/settleUp(expense)
/groupInfo(group)
/transactionHistory()

class balance{

}

class user{
    string id;
    list<expense> expensesAdded; List<group> groupsInvolved;
    map<groups, balance> balances; map<expense, userId> expenses; 
    map<string groupId, group> groupsInvolved; int balance;  map<user, expense> expensesInvolved;

    +transactionHistory(){
        return expensesAdded;
    }
    +createGroup(){
        return group.getGroup(); 
    }
    +createExpense(List<user> participants, splitType, amountToBeSplittted, group);{
        expense.createExpense(List<user> participants, splitType, amountToBeSplittted);
        groupsInvolved[groupId].addExpense(); 
    }
    +profile()
    +update(expense, user){
        this.expense[expense]  = user; this.balance -= expense.amount;  expensesInvolved[user] = expense;
    }
    +getBalance() return balance;
}

class Group{
    string groupId;
    map<user, expense> expensesInGroup;
    list<users> participants;  map<userid, balance> inquiry;

    +info(){
        return group;
    }
    +addExpense(expense){
    }
    +getGroup(List<user>participants){
        newgroup = new group(); newgroup.participants = participants;
    }
}

interface ExpenseCommand {
    void execute();
}

class AddExpenseCommand mplements ExpenseCommand{

}

interface SplitStrategy{+splitTheAmount();}

class EqualSplit implements splitStrategy{
    +splitTheAmount(expense){//implement the equal split //update in map of expense about inidiviual share.}
}
class %Split implements splitStrategy{
    +splitTheAmount(expense){//implement the % split //update in map of expense about inidiviual share.}
}
class ExactSplit implements splitStrategy{
    +splitTheAmount(expense){//implement the exact split //update in map of expense about inidiviual share.}
}

class Expense{

    double amount;
    string Id;
    user createBy;
    map<user,amount> splittedAmount; List<user> participants;

    +createExpense(List<user> participants, splitType split,double amountToBeSplittted){
        newexpense = new expense();
        if(split == equal) = equalSplit(expense); if(split == %) = %Split(expense); 
        if(split == exact) = exactlSplit(expense);  // also can apply factory method.

    +notify(){
        for each user in participants  user.update(expense, createby);
    }
}

class Metadata{///}

class Application{
    map<user, list<>>
    list<users> registeredUsers; List<group> group; userManager userManagerobj;
    main:
    application.initialize(); user.transactionHistory();
    user.createGroup(List<user> participants, metadata);
    user.createExpense(List<user> participants, splitType, amountToBeSplittted, group); 

    application.userManager.userInfo();

    +initialize() //assumed we have 10 registered users and 0 groups till now.

}


//how to identify as how user is clicking as everything we call from application.
//group.addExpense(expense); in this how system will know which group to call as there are many groups in system.



singleton class userManager{
    /add user /removeuser
    /userInfo{
        for each user in registeredUser: return user.getBalance();
    }
}



singleton class ExpenseManager{
    List<expenses> 
    map<user, List<expenses>> 

    map<user, List> 
    +getBalance(user?){
        /// iterate all expnses and manage 
    }
}



//capital in class start letter