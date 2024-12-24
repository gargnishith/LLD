Requirements:

The case study involved a live sale where users were divided into first-come, first-served and premium customers.
Premium users received a flat 10% discount on any product.
Normal users received 10% on the first purchase, 5% on the second, and 2% on subsequent purchases.


live sale
first-come, first-served
/price(user,item);

class user{
    Category categoryOfUser;
    list<itemsPurchased> 
}

class ProductMetaData{
    string productId;
    int price;

    +
}

class Product extends ProductMetaData{

}

interface DiscountStrategy{
    discountedPrice(int Price); 
}

class PremiumCustomerDiscountStrategy{

}

class NormalCustomerDiscountStrategy{

}

class Sale{

}

class SaleManager{

}

class Application{

}
