package com.warehouse.app;
import com.warehouse.model.Product;
import com.warehouse.model.Transaction;
import com.warehouse.service.WarehouseService;

import java.util.*;

public class WarehouseApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WarehouseService ws = new WarehouseService();
        boolean exit = false;
        while (!exit) {
            System.out.println("----------------------------------------------");
            System.out.println("        WAREHOUSE MANAGEMENT SYSTEM");
            System.out.println("----------------------------------------------");
            System.out.println("Please choose an option:");
            System.out.println();
            System.out.println("1.  Add New Product");
            System.out.println("2.  Update Existing Product");
            System.out.println("3.  Delete Product");
            System.out.println("4.  View Product by ID");
            System.out.println("5.  Search Product by Name");
            System.out.println("6.  Receive Stock (Add Quantity)");
            System.out.println("7.  Ship Stock (Reduce Quantity)");
            System.out.println("8.  Adjust Stock (Set New Quantity)");
            System.out.println("9.  View Low Stock Products");
            System.out.println("10. View All Products");
            System.out.println("11. View All Transactions");
            System.out.println("12. View Transactions for a Product");
            System.out.println("13. Calculate Total Inventory Value");
            System.out.println("14. View Stock by Category");
            System.out.println("15. Exit");
            System.out.println("----------------------------------------------");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.println("Please enter the product name:");
                    String name = sc.nextLine();
                    System.out.println("Please enter the product category: ");
                    String category = sc.nextLine();
                    System.out.println("Please enter the product quantity:");
                    int quantity = sc.nextInt();
                    while (quantity < 0) {
                        System.out.println("Please enter the valid product quantity:");
                        quantity = sc.nextInt();
                    }

                    System.out.println("Please enter the price of the product:");
                    double price = sc.nextDouble();
                    while (price < 0) {
                        System.out.println("Invalid price! Enter again:");
                        price = sc.nextDouble();
                    }
                    System.out.println("Please enter re-order Threshold");
                    int reorderThreshold = sc.nextInt();
                    while (reorderThreshold < 0) {
                        System.out.println("Invalid threshold! Enter again:");
                        reorderThreshold = sc.nextInt();
                    }
                    sc.nextLine();
                    System.out.println("Please enter supplier name");
                    String supplier = sc.nextLine();

                    ws.addProduct(name, category, quantity, price, reorderThreshold, supplier);
                    System.out.println("Product added successfully");
                    break;

                case 2:
                    sc.nextLine();  // clear leftover newline from menu choice
                    sc.nextLine();  // THIS FIXES THE ENTER ISSUE COMPLETELY

                    System.out.println("Enter the Product ID to update:");
                    int id = sc.nextInt();
                    sc.nextLine(); // clear after nextInt()

                    System.out.println("Enter new product name (or press ENTER to skip):");
                    String name1 = sc.nextLine();
                    if (name1.isEmpty()) name1 = null;

                    System.out.println("Enter new category (or press ENTER to skip):");
                    String category1 = sc.nextLine();
                    if (category1.isEmpty()) category1 = null;

                    System.out.println("Enter new price (or press ENTER to skip):");
                    String priceInput = sc.nextLine();
                    Double price1 = priceInput.isEmpty() ? null : Double.parseDouble(priceInput);

                    System.out.println("Enter new reorder threshold (or press ENTER to skip):");
                    String thresholdInput = sc.nextLine();
                    Integer reorderThreshold1 = thresholdInput.isEmpty() ? null : Integer.parseInt(thresholdInput);

                    System.out.println("Enter new supplier name (or press ENTER to skip):");
                    String supplier1 = sc.nextLine();
                    if (supplier1.isEmpty()) supplier1 = null;

                    boolean result = ws.updateProduct(id, name1, category1, price1, reorderThreshold1, supplier1);

                    if (result) {
                        System.out.println("Product updated successfully!");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;


                case 5:
                    sc.nextLine();  // clear buffer

                    System.out.println("Enter product name to search:");
                    String searchName = sc.nextLine();

                    List<Product> resultList = ws.searchProductsByName(searchName);

                    if (resultList.isEmpty()) {
                        System.out.println("No products found matching that name.");
                    } else {
                        System.out.println("Products found:");
                        for (Product p1 : resultList) {
                            System.out.println(p1); // uses Product.toString()
                        }
                    }
                    break;
                case 6:
                    sc.nextLine();
                    System.out.println("Enter product Id:");
                    int receivingStockId = sc.nextInt();
                    System.out.println("Enter quantity:");
                    int receivingQuantity = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Please enter important notes about stock if any");
                    String importantNotes = sc.nextLine();
                    boolean receivedStock = ws.receiveStock(receivingStockId, receivingQuantity, importantNotes);
                    if (receivedStock) {
                        System.out.println("Stock received successfully!");
                    } else {
                        System.out.println("Stock entry failed! Please try again");
                    }
                    break;
                case 7:
                    sc.nextLine();
                    System.out.println("Enter product Id to ship: ");
                    int shippingStockId = sc.nextInt();
                    System.out.println("Enter quantity to ship: ");
                    int shippingQuantity = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Please enter important notes about stock if any");
                    String shippingNotes = sc.nextLine();
                    boolean shipStock = ws.shipStock(shippingStockId, shippingQuantity, shippingNotes);
                    if (shipStock) {
                        System.out.println("Stock shipped successfully!");
                    } else {
                        System.out.println("Shipping failed! Please try again");
                    }
                    break;
                case 8:
                    sc.nextLine();
                    System.out.println("Enter product Id:");
                    int adjustingStockId = sc.nextInt();
                    System.out.println("Enter new quantity:");
                    int adjustingQuantity = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Please enter important notes about stock if any");
                    String adjustingNotes = sc.nextLine();
                    boolean adjustStock = ws.adjustStock(adjustingStockId, adjustingQuantity, adjustingNotes);
                    if (adjustStock) {
                        System.out.println("Stock adjustment successfully!");
                    } else {
                        System.out.println("Couldn't adjust! Please try again");
                    }
                    break;
                case 9:

                    List<Product> lowstock = ws.getLowStockProducts();
                    System.out.println("Low stock products:");
                    for(Product plow : lowstock) {
                        System.out.println(plow);
                    }
                    break;

                case 10:
                    List<Product> allproducts = ws.getAllProducts();
                    System.out.println("All products:");
                    for(Product allp : allproducts) {
                        System.out.println(allp);
                    }
                    break;

                case 11:

                    List<Transaction> lt = ws.getAllTransactions();
                    System.out.println("All transactions:");
                    for(Transaction tx : lt) {
                        System.out.println(tx);
                    }
                    break;

                case 12:
                    System.out.println("Enter product Id");
                    int pid = sc.nextInt();
                    List<Transaction> txp = ws.getTransactionsForProduct(pid);
                    System.out.println("Transactions for product ID: " + pid);
                    for(Transaction tx : txp) {
                        System.out.println(tx);
                    }
                    break;

                case 13:
                    double totalinventoryvalue = ws.calculateTotalInventoryValue();
                    System.out.println("Total inventory value is " + totalinventoryvalue);
                    break;

                case 14:
                    HashMap<String, Integer> categoryWiseStock =
                            new HashMap<>(ws.getStockByCategory());

                    System.out.println("Category-wise stock:");
                    for (Map.Entry<String, Integer> e : categoryWiseStock.entrySet()) {
                        System.out.println(e.getKey() + " : " + e.getValue());
                    }
                    break;


                case 15:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input!");


            }
        }
    }
}
