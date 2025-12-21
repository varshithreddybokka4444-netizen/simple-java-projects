package com.warehouse.model;

public class Product {
    final private int productId;

   private String name;

  private  String category;

   private int quantity;

   private double price;

   private int reorderThreshold;

   private String supplier;

public Product(int productId, String name, String category, int quantity, double price, int reorderThreshold, String supplier) {
    this.productId = productId;
    this.name = name;
    this.category = category;
    this.quantity = quantity;
    this.price = price;
    this.reorderThreshold = reorderThreshold;
    this.supplier = supplier;
}
  public  int getId(){
    return productId ;
    }// — returns id

   public String getName() {
    return name;
    }
   public void setName(String name) {
        this.name = name;
    };//— validation: non-null, non-empty

   public String getCategory() {
        return category;
    }
   public void setCategory(String category){

       this.category = category;
    }

 public int getQuantity() {

       return quantity;
    }
  public  void setQuantity(int qty){
        this.quantity = qty;
    } //— setQuantity should not allow negative values; if invalid, throw IllegalArgumentException

  public  double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }//— validate >= 0

  public  int getReorderThreshold() {

       return reorderThreshold;
    }
  public  void setReorderThreshold(int t){

       this.reorderThreshold = t;
    }// — validate >= 0
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

  public  boolean isLowStock() {
        return quantity<= reorderThreshold;
    }//— returns quantity <= reorderThreshold

    public String toString() {
        return "Product ID: " + productId +
                ", Name: " + name +
                ", Category: " + category +
                ", Quantity: " + quantity +
                ", Price: " + price +
                ", Supplier: " + supplier;
    }






}
