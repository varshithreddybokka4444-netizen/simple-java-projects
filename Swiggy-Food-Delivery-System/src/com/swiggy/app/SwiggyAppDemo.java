package com.swiggy.app;
import com.swiggy.order.GroceryOrder;
import com.swiggy.order.FoodOrder;
import com.swiggy.delivery.DeliveryAgent;

public class SwiggyAppDemo {
    public static void main(String[] args) {
    FoodOrder foodorder1 = new FoodOrder(101,"Neha",525,"Domino's","Margherita Pizza");
     foodorder1.placeOrder();
     foodorder1. displayOrderDetails();
     foodorder1.calculateBill();
     DeliveryAgent delivery1 = new DeliveryAgent("Rajesh","Bike");
delivery1.assignDeliveryPerson("Rajesh");
delivery1.startDelivery();
delivery1.completeDelivery();
System.out.println();


GroceryOrder groceryorder1 = new GroceryOrder(102,"Ramesh",315,"D-Mart","Vegetables");
groceryorder1.placeOrder();
groceryorder1.displayOrderDetails();
groceryorder1.calculateBill();

        DeliveryAgent delivery2 = new DeliveryAgent("Anitha","Scooter");
        delivery2.assignDeliveryPerson("Anitha");
        delivery2.startDelivery();
        delivery2.completeDelivery();





    }
}
