package com.medicalstore;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.medicalstore.entity.Stock;

 class StockTest {

    @Test
     void testConstructorAndGetters() {
        // Create a sample stock with specific values
        Long id = 1L;
        double purchasePrice = 10.5;
        LocalDate purchaseDate = LocalDate.now();
        int reorderLevel = 5;
        String location = "Warehouse";
        Long medicineId = 1001L;

        Stock stock = new Stock(id, purchasePrice, purchaseDate, reorderLevel, location, medicineId);

        // Verify that the constructor and getters set the values correctly
        assertEquals(id, stock.getId());
        assertEquals(purchasePrice, stock.getPurchasePrice());
        assertEquals(purchaseDate, stock.getPurchaseDate());
        assertEquals(reorderLevel, stock.getReorderLevel());
        assertEquals(location, stock.getLocation());
        assertEquals(medicineId, stock.getMedicineId());
    }

    @Test
     void testSetters() {
        // Create a sample stock
        Stock stock = new Stock();

        // Set values using setters
        Long id = 1L;
        double purchasePrice = 15.75;
        LocalDate purchaseDate = LocalDate.of(2022, 5, 10);
        int reorderLevel = 3;
        String location = "Pharmacy";
        Long medicineId = 2001L;

        stock.setId(id);
        stock.setPurchasePrice(purchasePrice);
        stock.setPurchaseDate(purchaseDate);
        stock.setReorderLevel(reorderLevel);
        stock.setLocation(location);
        stock.setMedicineId(medicineId);

        // Verify that the getters return the values set by setters
        assertEquals(id, stock.getId());
        assertEquals(purchasePrice, stock.getPurchasePrice());
        assertEquals(purchaseDate, stock.getPurchaseDate());
        assertEquals(reorderLevel, stock.getReorderLevel());
        assertEquals(location, stock.getLocation());
        assertEquals(medicineId, stock.getMedicineId());
    }
    
    @Test
     void testNotEqualsDifferentAttributes() {
        // Create two stocks with different attributes
        Stock stock1 = new Stock(1L, 10.5, LocalDate.of(2022, 1, 1), 5, "Warehouse", 1001L);
        Stock stock2 = new Stock(2L, 15.75, LocalDate.of(2022, 1, 1), 3, "Pharmacy", 2001L);
        
        // Assert that the two stocks are not equal
        assertNotEquals(stock1, stock2);
    }

    @Test
     void testNotEquals() {
        // Create two stocks with different attributes
        Stock stock1 = new Stock(1L, 10.5, LocalDate.of(2022, 1, 1), 5, "Warehouse", 1001L);
        Stock stock2 = new Stock(2L, 15.75, LocalDate.of(2022, 1, 1), 3, "Pharmacy", 2001L);
        
        // Assert that the two stocks are not equal
        assertNotEquals(stock1, stock2);
    }
    
    @Test
     void testHashCode() {
        // Create a stock
        Stock stock = new Stock(1L, 10.5, LocalDate.of(2022, 1, 1), 5, "Warehouse", 1001L);
        
        // Get the hash code
        int hashCode = stock.hashCode();
        
        // Assert that the hash code is not zero
        assertNotEquals(0, hashCode);
    }
}
