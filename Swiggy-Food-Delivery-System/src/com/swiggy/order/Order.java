package com.swiggy.order;

public class Order {
    int orderId;
  String customerName;
    double amount;
 public Order(){}

 public Order(int orderId, String customerName, double amount) {
     this.orderId = orderId;
     this.customerName = customerName;
     this.amount = amount;
 }

    public void placeOrder() {//: Print confirmation message.
     System.out.println("Order Placed");
 }
public void displayOrderDetails() {//Display all order info.
    //System.out.println("Order Details");
    System.out.println("Order ID: "+orderId);
    System.out.println("Customer Name: "+customerName);

}
    public void calculateBill(){//Calculates Bill
        System.out.println("Amount: ₹"+(amount+(0.05)*amount)+"(GST included)");
    }



}
