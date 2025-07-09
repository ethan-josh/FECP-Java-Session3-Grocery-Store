package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryGroceryTest {
    private final InventoryGrocery store = new InventoryGrocery();

    @BeforeEach
    void setup() {

        // init product
        store.addProduct("Milk", 20);
        store.addProduct("Bread", 15);
        store.addProduct("Eggs", 15);
    }

    @Test
    public void addNewProductWithValidQty(){
        String item = "Banana";
        int qty = 30;
        String actual = store.addProduct(item, qty);
        String expected = "Product added!";
        assertEquals(expected,actual);
    }

    @Test
    public void addProductWithInvalidQty(){
        String item = "Mango";
        int qty = 0;
        String actual = store.addProduct(item, qty);
        String expected = "Please input valid quantity.";
        assertEquals(expected,actual);
    }

    @Test
    public void addExistingProduct(){
        String item = "Milk";
        int qty = 50;
        String actual = store.addProduct(item, qty);
        String expected = "Product updated!";
        assertEquals(expected,actual);
    }

    @Test
    public void checkForExistingProduct(){
        String item = "Milk";
        String actual = store.checkProduct(item);
        String expected = "Milk is in stock: 20";
        assertEquals(expected,actual);
    }

    @Test
    public void checkForNonExistingProduct(){
        String item = "Ice Cream";
        String actual = store.checkProduct(item);
        String expected = "Product not found.";
        assertEquals(expected,actual);
    }

    @Test
    public void updateWithValidQty(){
        String item = "Bread";
        int qty = 25;
        store.updateProduct(item,qty);
        String actual = store.checkProduct(item);
        String expected = "Bread is in stock: 25";
        assertEquals(expected,actual);
    }

    @Test
    public void updateWithNonExistingProduct(){
        String item = "Tofu";
        String actual = store.updateProduct(item, 10);
        String expected = "Product not found.";
        assertEquals(expected,actual);
    }

    @Test
    public void  removeExisitingProduct() {
        String item = "Eggs";
        String actual = store.removeProduct(item);
        String expected = "Product removed.";
        assertEquals(expected, actual);
        // check if it is still in the map
        String inventoryOutput = store.viewInventory();
        assertFalse(inventoryOutput.contains(item));
    }

    @Test
    public void removeNonExistingProduct(){
        String item = "Pizza";
        String actual = store.removeProduct(item);
        String expected = "Product not found.";
        assertEquals(expected,actual);
    }

    @Test
    public void updateWithInvalidQty(){
        String item = "Bread";
        int qty = -1;
        String actual = store.updateProduct(item, qty);
        String expected = "Please input valid quantity.";
        assertEquals(expected, actual);
    }

    @Test
    public void checkEmptyInventory(){
        store.removeProduct("Milk");
        store.removeProduct("Bread");
        store.removeProduct("Eggs");
        String actual = store.viewInventory();
        String expected = "Inventory is empty.";
        assertEquals(expected,actual);
    }


}