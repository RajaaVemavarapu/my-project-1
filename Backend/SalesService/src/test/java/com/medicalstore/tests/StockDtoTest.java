package com.medicalstore.tests;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.medicalstore.dto.StockDto;

public class StockDtoTest {

    private StockDto stockDto;

    @BeforeEach
    public void setUp() {
        stockDto = new StockDto();
    }

    @Test
    public void testGetAndSetId() {
        Long id = 1L;
        stockDto.setId(id);
        assertEquals(id, stockDto.getId());
    }

    @Test
    public void testGetAndSetPurchasePrice() {
        double purchasePrice = 20.5;
        stockDto.setPurchasePrice(purchasePrice);
        assertEquals(purchasePrice, stockDto.getPurchasePrice(), 0.001);
    }

    @Test
    public void testGetAndSetPurchaseDate() {
        String purchaseDate = "2024-04-17";
        stockDto.setPurchaseDate(purchaseDate);
        assertEquals(purchaseDate, stockDto.getPurchaseDate());
    }

    @Test
    public void testGetAndSetReorderLevel() {
        int reorderLevel = 10;
        stockDto.setReorderLevel(reorderLevel);
        assertEquals(reorderLevel, stockDto.getReorderLevel());
    }

    @Test
    public void testGetAndSetLocation() {
        String location = "Warehouse A";
        stockDto.setLocation(location);
        assertEquals(location, stockDto.getLocation());
    }
}
