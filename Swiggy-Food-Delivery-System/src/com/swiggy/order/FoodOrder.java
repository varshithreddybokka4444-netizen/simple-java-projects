package com.swiggy.order;

public class FoodOrder extends Order{
   // Data Members:
    String restaurantName;
 String foodItem;
public FoodOrder(int orderId, String customerName, double amount,String restaurantName,String foodItem){
    super(orderId,customerName,amount);
    this.restaurantName = restaurantName;
    this.foodItem = foodItem;
}
    //Methods:
    @Override
  public void placeOrder() {//: Print confirmation message.
        System.out.println("Food Order Placed Successfully !");
    }
    @Override
public void displayOrderDetails() {//: Display all order info.
       // System.out.println("Order Details");
        System.out.println("Order ID: "+orderId);
        System.out.println("Customer Name: "+customerName);
        System.out.println("Restaurant Name: "+restaurantName);
        System.out.println("Item: "+foodItem);


    }
}
