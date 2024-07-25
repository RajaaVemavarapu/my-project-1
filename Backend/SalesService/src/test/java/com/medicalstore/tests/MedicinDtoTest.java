package com.medicalstore.tests;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.medicalstore.dto.MedicinDto;

public class MedicinDtoTest {

    private MedicinDto medicinDto;

    @BeforeEach
    public void setUp() {
        medicinDto = new MedicinDto();
    }

    @Test
    public void testGetAndSetId() {
        Long id = 1L;
        medicinDto.setId(id);
        assertEquals(id, medicinDto.getId());
    }

    @Test
    public void testGetAndSetName() {
        String name = "MedicineName";
        medicinDto.setName(name);
        assertEquals(name, medicinDto.getName());
    }

    @Test
    public void testGetAndSetDosage() {
        String dosage = "10mg";
        medicinDto.setDosage(dosage);
        assertEquals(dosage, medicinDto.getDosage());
    }

    @Test
    public void testGetAndSetPrice() {
        double price = 20.5;
        medicinDto.setPrice(price);
        assertEquals(price, medicinDto.getPrice(), 0.001);
    }

    @Test
    public void testGetAndSetExpirationDate() {
        LocalDate expirationDate = LocalDate.of(2025, 12, 31);
        medicinDto.setExpirationDate(expirationDate);
        assertEquals(expirationDate, medicinDto.getExpirationDate());
    }

    @Test
    public void testGetAndSetManufacturer() {
        String manufacturer = "ManufacturerName";
        medicinDto.setManufacturer(manufacturer);
        assertEquals(manufacturer, medicinDto.getManufacturer());
    }

    @Test
    public void testGetAndSetBatchNumber() {
        String batchNumber = "ABC123";
        medicinDto.setBatchNumber(batchNumber);
        assertEquals(batchNumber, medicinDto.getBatchNumber());
    }

    @Test
    public void testGetAndSetManufacturingDate() {
        LocalDate manufacturingDate = LocalDate.of(2020, 1, 1);
        medicinDto.setManufacturingDate(manufacturingDate);
        assertEquals(manufacturingDate, medicinDto.getManufacturingDate());
    }

    @Test
    public void testGetAndSetDescription() {
        String description = "Description of the medicine";
        medicinDto.setDescription(description);
        assertEquals(description, medicinDto.getDescription());
    }

    @Test
    public void testGetAndSetStockId() {
        Long stockId = 1L;
        medicinDto.setStockId(stockId);
        assertEquals(stockId, medicinDto.getStockId());
    }

    @Test
    public void testGetAndSetQuantity() {
        int quantity = 100;
        medicinDto.setQuantity(quantity);
        assertEquals(quantity, medicinDto.getQuantity());
    }
}
