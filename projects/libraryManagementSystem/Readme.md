Requirements:

The library management system should allow librarians to manage books, members, and borrowing activities.
The system should support adding, updating, and removing books from the library catalog.
Each book should have details such as title, author, ISBN, publication year, and availability status.
The system should allow members to borrow and return books.
Each member should have details such as name, member ID, contact information, and borrowing history.
The system should enforce borrowing rules, such as a maximum number of books that can be borrowed at a time and loan duration.
The system should handle concurrent access to the library catalog and member records.
The system should be extensible to accommodate future enhancements and new features.

Actors:

librarians, user

API's

/showBorrowings();
/showStock(book?);
/updateLibrary(book) //to adding, updating, and removing books from the library catalog
/bookDetail(book); //to get title, author, ISBN, publication year, and availability status.
/borrow(List<book>); //also to manage borrowing rules, such as a maximum number of books that can be borrowed at a time and loan duration. //handle concurrency while borrowing
/return(List<book>);
/userInfo();
/registerNewUser();

abstract class LibraryRules{
    LibraryRules nextRule;
    +check(user?, books?);
}

class loanRules implements LibraryRules{
    private int Threshhold = 10000 
    @override
    check(user,books?){
        if(user.getBalance()>=Threshold) return false;
        else this.nextRule = BookAvailableRules;
    }
}

class BookAvailableRules implements LibraryRules{
    @override
    check(user,books?){
        if(user.getBalance()>=Threshold) return false;
        else this.nextRule = NoOfBooks;
    }
}

class NoOfBooks implements LibraryRules{
    @override
    check(user,books?){
        if(user.getBalance()>=Threshold) return false; else return true;
    }
}

class Book{
    string bookId;
    bool isAvailable;
    double price;
    map<user, bill> purchase;

    +synchronised buy(User userPurchase);
    {
        this.isAvailable = false; 
    }
    +return();{
        this.isAvailable = true; 
    }
}

class User{
    string userId;
    string userName; 
    map<book,bill> purchases; 
    double loan; 

    +registerUser(); //to add new user in system.
    +userInfo();
    +userPurchases(book);{
        LibraryRules = new loanRules; 
        if(LibraryRules.check(this, book)==true) book.buy(user); Bill.generateBill(userPurchase, book);
    }
    +booksBorrowedByUser();
    +return(book);{
        book.return(); purchases[book].payBill();
    }
}

ENUM BillStatus = {"unpaid","paid"}

class Bill{
    string billId;
    List<book> books;
    user purchasedBy;
    BillStatus status;

    +generateBill(userPurchase, book);
    +payBill();{this.status = paid;}
}

class Admin{
    string adminID; library libraryRoom;

    +addBooks(book);{
        this.libraryRoom.booksInfo[book] = null;
    }
    +removeBooks(book);{
        this.libraryRoom.booksInforemove(book)
    }
    +registerUser(user);{
        this.libraryRoom.userInfo[user.userID] = user;
    }

}

class Library{

    map<books, user> booksInfo; map<userId,user> userInfo; map<user, List<bill>> userPurchases; Admin adminLibrary; map<user, List<Bill>> userHistory;
    main{
        libraryRoom = new Library(); libraryRoom.initialize(); libraryRoom.booksInfo[book].return(); booksInfo[book] = null;
        libraryRoom.userInfo[userId].buy();   booksInfo[book] = user;
        admin.addBooks(book)
    }

    +initialize();{
        //create a new adminLibrary;
        //add sample books booksInfo by adminLibrary;
        //add users
        adminLibrary.libraryRoom = libraryRoom;
    }


}




