package com.warehouse.service;
import java.util.*;

import com.warehouse.model.Product;
import com.warehouse.model.Transaction;
import java.util.List;

public class WarehouseService {

    private List<Product> products;
    private List<Transaction> transactions;

    private int nextProductId;
    private int nextTransactionId;          


    public WarehouseService() {
        this.products = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.nextProductId = 100;
        this.nextTransactionId = 1000;
    }

    public void addProduct(String name, String category, int quantity, double price, int reorderThreshold, String supplier) {
        int id = nextProductId++;
        Product product = new Product(id, name, category, quantity, price, reorderThreshold, supplier);

        products.add(product);

        if (quantity > 0) {
            int tId = nextTransactionId++;
            String timestamp = java.time.LocalDateTime.now().toString();

            Transaction t = new Transaction(tId, id, "RECEIVE", quantity, timestamp, "Initial stock added");

            transactions.add(t);
        }
    }

    public boolean updateProduct(int productId, String name, String category, Double price,
                                 Integer reorderThreshold, String supplier) {
        Product product = findProductById(productId);
           if (product == null) return false;

            if (name != null) {
                product.setName(name);
            }

            if (category != null) {
                product.setCategory(category);
            }


            if (price != null) {
                product.setPrice(price);
            }

            if (reorderThreshold != null) {
                product.setReorderThreshold(reorderThreshold);
            }

            if (supplier != null) {
                product.setSupplier(supplier);
            }
            return true;

    }

    
    public boolean deleteProduct(int productId) {
        Product product = findProductById(productId);
        if (product != null) {
            products.remove(product);
            return true;
        }
        return false;

    }

   
    public Product getProductById(int productId) {
        Product product = findProductById(productId);
        if (product != null) {
            return product;
        }
        return null;
    }


    public List<Product> searchProductsByName(String name) {
        List<Product> items = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                items.add(product);
            }

        }
        return items;
    }

    public boolean receiveStock(int productId, int quantity, String note) {
        Product p = findProductById(productId);
        if (p == null) return false;
        if (quantity <= 0) return false;
        p.setQuantity(p.getQuantity() + quantity);
        int tid = nextTransactionId++;
        String timestamp = java.time.LocalDateTime.now().toString();

        Transaction t = new Transaction(tid, productId, "RECEIVE", quantity, timestamp, note);
        transactions.add(t);
        return true;
    }

    // Ship (reduce) stock
    public boolean shipStock(int productId, int quantity, String note) {

        Product p = findProductById(productId);
        if (p == null) return false;

        if (quantity <= 0) return false;
        if (p.getQuantity() < quantity) return false;

        p.setQuantity(p.getQuantity() - quantity);
        int tid = nextTransactionId++;
        String timestamp = java.time.LocalDateTime.now().toString();
        Transaction t = new Transaction(tid, productId, "SHIP", quantity, timestamp, note);
        transactions.add(t);
        return true;
    }

    // Adjust stock (set new quantity)    // Receive (add) stock
    public boolean adjustStock(int productId, int newQuantity, String note) {
        if(newQuantity < 0) return false;
        Product p = findProductById(productId);

        if (p == null) return false;
        int difference = newQuantity - p.getQuantity();
        if (difference == 0) return false;
        p.setQuantity(newQuantity);
        int tid = nextTransactionId++;
        String timestamp = java.time.LocalDateTime.now().toString();
        Transaction t = new Transaction(tid, productId, "ADJUST", difference, timestamp, note);
       transactions.add(t);

        return true;
    }

    // Low stock products
    public List<Product> getLowStockProducts() {
        List<Product> lowstockproducts = new ArrayList<>();
        for (Product p : products) {
            if (p.getQuantity() <= p.getReorderThreshold()) {
                lowstockproducts.add(p);
            }
        }

        return lowstockproducts;
    }
public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
}
    // All transactions of specific product
    public List<Transaction> getTransactionsForProduct(int productId) {
        List<Transaction> transaction = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getProductId() == productId) {
                transaction.add(t);
            }
        }
        return transaction;
    }

    // All transactions overall
    public List<Transaction> getAllTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    // Total inventory value
    public double calculateTotalInventoryValue() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice() * p.getQuantity();
        }
        return total;
    }


    public Map<String, Integer> getStockByCategory() {
        Map<String, Integer> stock = new HashMap<>();
        for (Product p : products) {
            String category = p.getCategory();
            int qty = p.getQuantity();
            if (stock.containsKey(category)) {
                stock.put(category, stock.get(category) + qty);
            } else {
                stock.put(category, qty);
            }

        }
        return stock;
    }


    private Product findProductById(int productId) { // Get a single product by ID
        for (Product p : products) {
            if (p.getId() == productId) {
                return p;
            }
        }
        return null;


    }
}
