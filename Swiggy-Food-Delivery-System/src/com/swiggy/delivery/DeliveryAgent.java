package com.swiggy.delivery;

public class DeliveryAgent extends Delivery{
    String agentName;
     String vehicleType;
     public DeliveryAgent(String agentName,String vehicleType){
         this.agentName = agentName;
         this.vehicleType = vehicleType;
     }
     @Override
   public void assignDeliveryPerson(String name){
        System .out.println("Delivery Assigned: "+name+" ("+vehicleType+")");
    }



}
