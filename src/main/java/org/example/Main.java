package org.example;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void showMenu(){
        System.out.println("--- Grocery Inventory Menu ---");
        System.out.println("1. View Inventory");
        System.out.println("2. Add Product");
        System.out.println("3. Check Product");
        System.out.println("4. Update Stock");
        System.out.println("5. Remove Product");
        System.out.println("6. Exit");
        System.out.print("Choose option: ");
    }
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        InventoryGrocery store = new InventoryGrocery();
        // init product
        store.addProduct("Milk", 20);
        store.addProduct("Bread", 15);
        store.addProduct("Eggs", 15);
        int userChoice = 0;

        while (userChoice != 6){
            showMenu();
            Scanner loopObj = new Scanner(System.in);
            userChoice = myObj.nextInt();

            switch (userChoice){
                case 1: // View Inventory
                    System.out.println();
                    store.viewInventory();
                    System.out.println();
                    break;
                case 2: // Add Product
                    System.out.println();
                    break;
                case 3: // Check Product
                    System.out.print("Enter product name to check: ");
                    String productToCheck = loopObj.next();
                    System.out.println(store.checkProduct(productToCheck));
                    System.out.println();
                    break;
                case 4: // Update Stock
                    System.out.println();
                    break;
                case 5: // Remove Product
                    System.out.println();
                    break;
                case 6:
                    System.out.println();
                    break;
            }
        }


    }
}