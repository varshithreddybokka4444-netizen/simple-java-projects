package com.warehouse.model;

public class Transaction {
  final  private int transactionId;

    private int productId;

    private String type;// → "RECEIVE", "SHIP", "ADJUST"

    private int quantity;

    private String timestamp;

    private String note;

public Transaction(int transactionId,int productId,String type,int quantity,String timestamp,String note){
    this.transactionId = transactionId;
    this.productId  = productId;
    this.type = type;
    this.quantity = quantity;
    this.timestamp = timestamp;
    this.note = note;
}
    public int getTransactionId(){
    return transactionId;
    }
  public int getProductId(){
    return productId;
   }
  public String getType(){
    return type;
   }
  public int getQuantity(){
    return quantity;
   }
   public String getTimestamp(){
    return timestamp;
    }
  public String getNote(){
    return note;
   }
@Override
public String toString(){
     return transactionId + " | " + productId + " | " + type +
            " | Qty: " + quantity + " | " + timestamp +
            " | Note: " + note;

}


}
