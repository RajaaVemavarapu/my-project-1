package com.medicalstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.medicalstore.entity.Stock;
import com.medicalstore.repository.StockRepository;
import com.medicalstore.service.StockService;

 class StockServiceTest {

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockService stockService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testGetAllStock() {
        // Mock repository
        List<Stock> mockStocks = new ArrayList<>();
        mockStocks.add(new Stock());
        mockStocks.add(new Stock());
        when(stockRepository.findAll()).thenReturn(mockStocks);

        // Call service method
        List<Stock> result = stockService.getAllStock();

        // Assert
        assertEquals(2, result.size());
    }

    @Test
     void testGetStockById_Exists() {
        // Mock data
        Long id = 1L;
        Stock mockStock = new Stock();
        mockStock.setId(id);

        // Mock repository
        when(stockRepository.findById(id)).thenReturn(Optional.of(mockStock));

        // Call service method
        Stock result = stockService.getStockById(id);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
     void testGetStockById_Exists1() {
        // Mock data
        Long id = 1L;
        Stock mockStock = new Stock();
        mockStock.setId(id);

        // Configure mock repository to return the mock stock
        when(stockRepository.findById(id)).thenReturn(Optional.of(mockStock));

        // Call the service method
        Stock result = stockService.getStockById(id);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
    }


    @Test
     void testSaveStock() {
        // Mock data
        Stock mockStock = new Stock();

        // Mock repository
        when(stockRepository.save(mockStock)).thenReturn(mockStock);

        // Call service method
        Stock result = stockService.saveStock(mockStock);

        // Assert
        assertNotNull(result);
    }

    @Test
     void testDeleteStockById() {
        // Mock data
        Long id = 1L;

        // Call service method
        stockService.deleteStockById(id);

        // Verify repository method called
        verify(stockRepository).deleteById(id);
    }

    @Test
     void testGetStockByMedicineId() {
        // Mock data
        Long medicineId = 123L;
        Stock mockStock = new Stock();
        mockStock.setMedicineId(medicineId);

        // Mock repository
        when(stockRepository.findByMedicineId(medicineId)).thenReturn(mockStock);

        // Call service method
        Stock result = stockService.getStockByMedicineId(medicineId);

        // Assert
        assertNotNull(result);
        assertEquals(medicineId, result.getMedicineId());
    }
}
