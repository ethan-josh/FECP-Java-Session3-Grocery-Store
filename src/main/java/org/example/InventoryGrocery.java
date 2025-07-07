package org.example;
import java.util.*;

public class InventoryGrocery {
    private Map<String, Integer> inventory;

    public InventoryGrocery() {
        inventory = new HashMap<>();
    }

    public String viewInventory() {
        if (inventory.isEmpty()) {
            return "Inventory is empty.";
        } else {
            System.out.println("Current Inventory:");
            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue() + "pcs");
            }
            List<Map.Entry<String, Integer>> inventoryOutput = inventory.entrySet().stream().toList();
            return inventoryOutput.toString();
            }
        }

    public String addProduct(String productName, int quantity) {
        if (inventory.containsKey(productName)) {
            return productName + " already exists (Try using update instead).";
        } else {
            inventory.put(productName, quantity);
            return "Product added";
        }
    }

    public String checkProduct(String productName) {
        if (inventory.containsKey(productName)) {
            return productName + " is in stock: " + inventory.get(productName);
        } else {
            return productName + " is not available.";
        }
    }

    }

