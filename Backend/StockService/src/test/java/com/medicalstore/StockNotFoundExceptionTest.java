package com.medicalstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.medicalstore.exception.StockNotFoundException;

 class StockNotFoundExceptionTest {

    @Test
    void testConstructor() {
        String errorMessage = "Stock not found";
        StockNotFoundException exception = new StockNotFoundException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
     void testThrowingException() {
        try {
            throwStockNotFoundException();
            // If the exception is not thrown, fail the test
            assertTrue(false);
        } catch (StockNotFoundException e) {
            // Test passes if StockNotFoundException is thrown
            assertEquals("Stock not found", e.getMessage());
        }
    }


    private void throwStockNotFoundException() {
        throw new StockNotFoundException("Stock not found");
    }
    
    @Test
     void testThrowingExceptionWithCustomMessage() {
        String customMessage = "Custom stock not found message";
        try {
            throwStockNotFoundExceptionWithCustomMessage(customMessage);
            // If the exception is not thrown, fail the test
            assertTrue(false);
        } catch (StockNotFoundException e) {
            // Test passes if StockNotFoundException is thrown
            assertEquals(customMessage, e.getMessage());
        }
    }

    private void throwStockNotFoundExceptionWithCustomMessage(String message) {
        throw new StockNotFoundException(message);
    }
}
